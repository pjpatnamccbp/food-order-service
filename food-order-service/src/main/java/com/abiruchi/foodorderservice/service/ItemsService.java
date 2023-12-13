package com.abiruchi.foodorderservice.service;

import com.abiruchi.foodorderservice.dto.ItemDto;
import com.abiruchi.foodorderservice.excepion.ItemNotAvailableException;
import com.abiruchi.foodorderservice.excepion.ItemNotFoundException;

import java.util.List;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
public interface ItemsService {
    ItemDto saveItems(ItemDto itemDto);
    List<ItemDto> getAllItems();

    ItemDto getItemByName(String itemName) throws ItemNotAvailableException;
}
