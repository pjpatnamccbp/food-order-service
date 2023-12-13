package com.abiruchi.foodorderservice.service;

import com.abiruchi.foodorderservice.dto.OrderRequest;
import com.abiruchi.foodorderservice.dto.OrderResponse;
import com.abiruchi.foodorderservice.excepion.ItemNotAvailableException;
import com.abiruchi.foodorderservice.excepion.ItemNotFoundException;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
public interface IOrderService {
    OrderResponse orderFood(OrderRequest orderRequest) throws ItemNotAvailableException;
}
