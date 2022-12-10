package com.newProject.Dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class BillDto {
    
    private Long billId;
    private Long userId;
    private String userName;
    private Long prdId;
    private String productName;
    private Long productQuan;
    private float productAmt;
    private LocalDate billDate;
    private Boolean isCancelled;
   
}
