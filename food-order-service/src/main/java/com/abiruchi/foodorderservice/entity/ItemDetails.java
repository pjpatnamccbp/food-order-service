package com.abiruchi.foodorderservice.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
@Entity
@Table(name = "item_details")
@Data
public class ItemDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String itemName;
    private String itemType;
    private String description;
    private Float price;
}
