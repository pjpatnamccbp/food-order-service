package com.abiruchi.foodorderservice.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
@Entity
@Table(name = "order_details")
@Data
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String itemName;
    private String itemType;
    private String description;
    private Integer quantity;
    private String deliveryAddress;

    private Float amount;
    private String paymentMode;
}
