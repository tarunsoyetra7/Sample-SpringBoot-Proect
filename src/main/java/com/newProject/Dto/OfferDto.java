package com.newProject.Dto;

import java.util.Date;
import lombok.Data;

@Data
public class OfferDto{
    
    private long offerId;
    private long catId;
    private String catName;
    private Date offerSDate;
    private Date offerEDate;
    private int offerVal;

}
