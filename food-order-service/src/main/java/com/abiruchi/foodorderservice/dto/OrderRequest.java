package com.abiruchi.foodorderservice.dto;

import lombok.Data;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/

@Data
public class OrderRequest {
    private String itemName;
    private String itemType;
    private String description;
    private Integer quantity;
    private String deliveryAddress;
    private String paymentMode;
}
