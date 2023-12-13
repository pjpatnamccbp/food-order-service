package com.abiruchi.foodorderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {
    private Long orderId;
    private String responseCode;
    private String responseMsg;
    private String itemName;
    private Float bill;
    private String status;
}
