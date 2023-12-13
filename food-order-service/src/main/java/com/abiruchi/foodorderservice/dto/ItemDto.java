package com.abiruchi.foodorderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDto {
    private Long itemId;
    private String itemName;
    private Float price;
    //private String available;
    private String description;
    private String itemType;
}
