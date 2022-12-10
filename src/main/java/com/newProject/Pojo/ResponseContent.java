package com.newProject.Pojo;

import java.util.List;

import com.newProject.Dto.BillDto;
import com.newProject.Dto.OfferDto;
import com.newProject.Dto.ProductDto;
import com.newProject.Dto.UserDto;
import lombok.Data;

@Data
public class ResponseContent {

    private int statusCode;
    private String message;
    private List<ProductDto> productDtoList;
    private List<UserDto> userDtoList;
    private List<BillDto> billDtoList;
    private List<OfferDto> offerDtoList;
    
}
