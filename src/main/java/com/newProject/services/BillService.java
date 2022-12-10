package com.newProject.services;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.newProject.repositories.BillRepository;
import com.newProject.repositories.UserRepository;
import com.newProject.repositories.CartRepository;
import com.newProject.repositories.OfferRepository;
import com.newProject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newProject.Dto.BillDto;
import com.newProject.models.Bill;
import com.newProject.models.Cart;

@Service
public class BillService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OfferRepository offerRepository;

    public String calculateBill(Long userId) {
        List<Cart> cartdetails = new ArrayList<>();
        List<Bill> resultList = new ArrayList<>();
        cartdetails = cartRepository.getCartDetailById(userId);
        if(cartdetails.size() == 0){
            return "Fail";
        }
        else{
            for(Cart cartdetail : cartdetails){
                Bill bill = new Bill();
                float totalAmt = 0;
                LocalDate now = LocalDate.now();
                DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String text = now.format(formatters);
                LocalDate parsedDate = LocalDate.parse(text, formatters);
                Long prdCost = productRepository.findById(cartdetail.getProduct().getPrdId()).get().getPrdRate();
                Long prdCatId = productRepository.findById(cartdetail.getProduct().getPrdId()).get().getCategory().getCatId();
                int prdOffer = 0;
                if(offerRepository.getOfferByCatIdBtwnCurDate(parsedDate,prdCatId).isEmpty()){
                    prdOffer = 100;
                }
                else{
                    prdOffer = 100 - offerRepository.getOfferByCatIdBtwnCurDate(parsedDate,prdCatId).get().getOfferVal();
                } 
                totalAmt = totalAmt + (cartdetail.getPrdQuantity()*prdCost*prdOffer/100);
                bill.setUserId(userRepository.findById(userId).get());
                bill.setBillAmt(totalAmt);
                bill.setProduct(cartdetail.getProduct());
                bill.setBillProductQuan(cartdetail.getPrdQuantity());
                bill.setBillDate(java.time.LocalDate.now());
                bill.setCancelled(false);
                resultList.add(bill);
            }
            billRepository.saveAll(resultList);
            return "Success";
        }
        
    }

    @Transactional
    public void deleteCartDetail(Long userId) {
        cartRepository.deleteCartByUserId(userId);
    }

    public String returnProductById(Long billId) {
        LocalDate curDate = LocalDate.now();
        Optional<Bill> optional = billRepository.getByBillId(billId);
        if(optional.isEmpty()){
            return "Problem";
        }
        else{
            LocalDate billDate = optional.get().getBillDate();
            if(billDate.plusDays(7).isBefore(curDate)){
                return "Fail";
            }
            else{
                Bill bill = new Bill();
                bill = optional.get();
                bill.setCancelled(true);
                billRepository.save(bill);
                return "Success";
            }
        }
        
    }

    public List<BillDto> getBilletails(Long Id) {
        List<Bill> billDetails = billRepository.getBillByUser(Id);
        List<BillDto> result = new ArrayList<>();
        for (Bill billDetail : billDetails){
            BillDto billDto = new BillDto();
            billDto.setBillId(billDetail.getBillId());
            billDto.setUserId(billDetail.getUserId().getId());
            billDto.setPrdId(billDetail.getProduct().getPrdId());
            billDto.setProductQuan(billDetail.getBillProductQuan());
            billDto.setBillDate(billDetail.getBillDate());
            billDto.setProductAmt(billDetail.getBillAmt());
            billDto.setProductName(productRepository.check(billDetail.getProduct().getPrdId()).get().getPrdName());
            billDto.setUserName(userRepository.getUserById(billDetail.getUserId().getId()).getUserName());
            billDto.setIsCancelled(billDetail.isCancelled());
            result.add(billDto);
        }
        return result;
    }
    
}
