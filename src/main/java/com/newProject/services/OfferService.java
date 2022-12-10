package com.newProject.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.newProject.Dto.OfferDto;
import com.newProject.models.Offer;
import com.newProject.repositories.CategoryRepository;
import com.newProject.repositories.OfferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OfferService {

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public String saveOfferDetails(long catId,Date offerSDate,Date offerEDate, int offerVal) {

        Offer offerdetail = new Offer();
        offerdetail.setCategories(Arrays.asList(categoryRepository.findById(catId).get()));
        offerdetail.setOfferSDate(offerSDate);
        offerdetail.setOfferEDate(offerEDate);
        offerdetail.setOfferVal(offerVal);
        try {
            offerRepository.save(offerdetail);
            return "Data Saved Successfully ........";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    // Need to review Code
    public List<OfferDto> getAllOffer(){
        List<Offer> offerDetails = offerRepository.getAllOffers();
        List<OfferDto> offerDatas = new ArrayList<>();
        for (Offer offerDetail : offerDetails){
            OfferDto offerData = new OfferDto();
            offerData.setOfferId(offerDetail.getOfferId());
           // offerData.setCatId(categoryRepository.findById(offerDetail.getCategory().getCatId()).get().getCatId());
           // offerData.setCatName(categoryRepository.getCatById(categoryRepository.findById(offerDetail.getCategory().getCatId()).get().getCatId()).get().getCatName());
            offerData.setOfferEDate(offerDetail.getOfferEDate());
            offerData.setOfferSDate(offerDetail.getOfferSDate());
            offerData.setOfferVal(offerDetail.getOfferVal());
            offerDatas.add(offerData);
        }
        return offerDatas;
    }

    public String updateOfferDetails(Long Id,Long catId,Date offerSDate,Date offerEDate, int offerVal) {

        Optional<Offer> optional = offerRepository.findById(Id);
        if(optional.isPresent()){
            Offer offerdetail = optional.get();
            offerdetail.setCategories(Arrays.asList(categoryRepository.findById(catId).get()));
            offerdetail.setOfferSDate(offerSDate);
            offerdetail.setOfferEDate(offerEDate);
            offerdetail.setOfferVal(offerVal);
            try {
                offerRepository.save(offerdetail);
                return "Data Updated Successfully ........";
            } catch (Exception e) {
                return e.getMessage();
            }
        }
        else{
            return "No Data Found with Id :"+Id;
        }    
    }

    @Transactional
    public String deleteOfferById(Long Id){
        Optional<Offer> optional = offerRepository.check(Id);
        if(optional.isPresent()){
            offerRepository.deleteById(Id);
            return "Offer Deleted Successfully .......";
        }
        else{
            return "No Data Found with Id : "+Id;
        }
        
    }
    
    // Need to review code
    public OfferDto validateAndGetOfferByCatId(Long catId){
        if(categoryRepository.getCatById(catId).isEmpty()){
            return null;
        }
        else{ 
            Optional<Offer> optional = offerRepository.getOfferDetailsByCatid(catId);
            Offer offerDetail = new Offer();
            OfferDto offerData = new OfferDto();
            if(optional.isEmpty()){
                offerData = null;
            }
            else{
                // offerDetail = optional.get();
                // offerData.setOfferId(offerDetail.getOfferId());
                // offerData.setCatId(Arrays.asList(offerDetail.getCategory().getCatId());
                // offerData.setCatName(categoryRepository.getCatById(
                // offerDetail.getCategory().getCatId()).get().getCatName());
                // offerData.setOfferEDate(offerDetail.getOfferEDate());
                // offerData.setOfferSDate(offerDetail.getOfferSDate());
                // offerData.setOfferVal(offerDetail.getOfferVal());
            }   
            return offerData;
        }
    }
}
