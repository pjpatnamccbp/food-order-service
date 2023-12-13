package com.abiruchi.foodorderservice.controller;

import com.abiruchi.foodorderservice.dto.OrderRequest;
import com.abiruchi.foodorderservice.dto.OrderResponse;
import com.abiruchi.foodorderservice.excepion.ItemNotAvailableException;
import com.abiruchi.foodorderservice.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
@RestController
@RequestMapping("/abiruchi")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/order")
    public OrderResponse orderFood(@RequestBody OrderRequest orderRequest) throws ItemNotAvailableException {
        return orderService.orderFood(orderRequest);
    }


}
