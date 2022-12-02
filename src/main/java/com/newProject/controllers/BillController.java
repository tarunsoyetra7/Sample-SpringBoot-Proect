package com.newProject.controllers;

import com.newProject.Dto.BillDto;
import com.newProject.models.Bill;
import com.newProject.services.BillService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BillController {

    @Autowired
    BillService billService;
    
    public ResponseEntity<Bill> getBill(){
        return null;
    }

    @PostMapping("/saveBill/{userId}")
    public ResponseEntity<String> saveBill(@PathVariable Long userId) {
        String response = billService.calculateBill(userId);
        if(response.equals("Success")){
            response = "Bill Generated Successfully ............";
            billService.deleteCartDetail(userId);
            return new ResponseEntity<>(response , HttpStatus.OK);
        }
        else{
            response = "Your Cart is Empty .............";
            return new ResponseEntity<>("response" , HttpStatus.NOT_FOUND);
        }     

    }

    @PostMapping("/returnItem/{billId}")
    public ResponseEntity<String> returnProduct(@PathVariable Long billId){

        String response = billService.returnProductById(billId);
        if(response.equals("Success")){
            response = "Product returned Successfully ........";
            return new ResponseEntity<>(response , HttpStatus.OK);
        }
        else if(response.equals("Fail")){
            response = "Product cannot be Returned ........";
            return new ResponseEntity<>(response , HttpStatus.NOT_ACCEPTABLE);
        }
        else{
            response = "Product Returned Request Failed .....";
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBill/{Id}")
    public ResponseEntity<List<BillDto>> getBillByUser(@PathVariable Long Id){
        List<BillDto> response = billService.getBilletails(Id);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return new ResponseEntity<>(response , HttpStatus.OK);
        }
        
    }
}
