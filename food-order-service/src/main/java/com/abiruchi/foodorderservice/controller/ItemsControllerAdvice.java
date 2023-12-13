package com.abiruchi.foodorderservice.controller;

import com.abiruchi.foodorderservice.dto.ItemDto;
import com.abiruchi.foodorderservice.dto.OrderResponse;
import com.abiruchi.foodorderservice.excepion.ItemNotAvailableException;
import com.abiruchi.foodorderservice.excepion.ItemNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
@ControllerAdvice
public class ItemsControllerAdvice {

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseBody
    public ItemDto handleItemNotFoundException(ItemNotFoundException exception){
        ItemDto itemDto = new ItemDto();
        itemDto.setDescription(exception.getErrorCode());
        return itemDto;
    }
    @ExceptionHandler(ItemNotAvailableException.class)
    @ResponseBody
    public OrderResponse handleItemNotAvailableException(ItemNotAvailableException exception){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setResponseCode(exception.getErrorCode());
        orderResponse.setResponseMsg(exception.getErrorMsg());
        return orderResponse;
    }
}
