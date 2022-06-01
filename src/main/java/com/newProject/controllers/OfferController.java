package com.newProject.controllers;



import java.util.Date;
import java.util.List;

import com.newProject.Dto.OfferDto;
import com.newProject.services.OfferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController{

    @Autowired
    private OfferService offerService;

    @PostMapping("/saveOffer")
    public ResponseEntity<String> saveOffer(@RequestParam long catId, @RequestParam Date offerSDate,
                                            @RequestParam Date offerEDate, @RequestParam int offerVal){
        String response = offerService.saveOfferDetails(catId, offerSDate, offerEDate,offerVal);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getOffers",method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OfferDto>> getOffers() {
        List<OfferDto> response = offerService.getAllOffer();
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return new ResponseEntity<>(response , HttpStatus.OK);
        }
        
    }

    @PostMapping("/updateOffer")
    public ResponseEntity<String> updateOffer(@RequestParam long Id, @RequestParam long catId, @RequestParam Date offerSDate,
                                            @RequestParam Date offerEDate, @RequestParam int offerVal){
        String response = offerService.updateOfferDetails(Id, catId, offerSDate, offerEDate,offerVal);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @DeleteMapping("/deleteOffer/{Id}")
    public ResponseEntity<String> deleteOffer(@PathVariable long Id) {
        String respose = offerService.deleteOfferById(Id);
        return new ResponseEntity<>(respose , HttpStatus.OK);
    }

    @GetMapping("/getOfferByCat/{catId}")
    public ResponseEntity<OfferDto> getOfferByCatId(@PathVariable Long catId){
        OfferDto response = offerService.validateAndGetOfferByCatId(catId);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        
    }

}