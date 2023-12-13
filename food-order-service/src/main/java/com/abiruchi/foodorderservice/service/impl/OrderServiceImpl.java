package com.abiruchi.foodorderservice.service.impl;

import com.abiruchi.foodorderservice.dto.ItemDto;
import com.abiruchi.foodorderservice.dto.OrderRequest;
import com.abiruchi.foodorderservice.dto.OrderResponse;
import com.abiruchi.foodorderservice.entity.OrderDetails;
import com.abiruchi.foodorderservice.excepion.ItemNotAvailableException;
import com.abiruchi.foodorderservice.repository.OrderRepository;
import com.abiruchi.foodorderservice.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;

    String get_item_url = "http://localhost:8181/api/items/";
    @Override
    public OrderResponse orderFood(OrderRequest orderRequest) throws ItemNotAvailableException {
        String itemName = orderRequest.getItemName();
        ItemDto itemDto = restTemplate.getForObject(get_item_url+itemName,ItemDto.class);
        OrderDetails savedOderDetails; //orderRepository.save(buildOrderDetails(orderRequest, itemDto.getPrice()));
//        try {
            if ("item404".equals(itemDto.getDescription())) {
//                System.out.println("throwing not avaiable exception");
                throw new ItemNotAvailableException("item404", "item not available at restaurent");
            } else {
                savedOderDetails = orderRepository.save(buildOrderDetails(orderRequest, itemDto.getPrice()));
            }
//        }catch (ItemNotAvailableException exception){
//            exception.printStackTrace();
//        }

        //OrderDetails savedOderDetails = orderRepository.save(buildOrderDetails(orderRequest,itemDto.getPrice()));

        OrderResponse orderResponse = getOrderResponse(savedOderDetails);

        return orderResponse;
    }

    public static OrderResponse getOrderResponse(OrderDetails savedOderDetails) {


        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(savedOderDetails.getOrderId());
        orderResponse.setBill(savedOderDetails.getAmount());
        orderResponse.setItemName(savedOderDetails.getItemName());
        orderResponse.setResponseCode("0");
        orderResponse.setResponseMsg("..... order placed .....");
        orderResponse.setStatus("item on the way");

        return orderResponse;
    }

    private OrderDetails buildOrderDetails(OrderRequest orderRequest,Float price) {
        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setItemName(orderRequest.getItemName());
        orderDetails.setDescription(orderRequest.getDescription());
        orderDetails.setQuantity(orderRequest.getQuantity());
        orderDetails.setDeliveryAddress(orderRequest.getDeliveryAddress());
        orderDetails.setPaymentMode(orderRequest.getPaymentMode());
        orderDetails.setItemType(orderRequest.getItemType());
        orderDetails.setAmount(orderRequest.getQuantity() * price);

        return orderDetails;
    }
}
