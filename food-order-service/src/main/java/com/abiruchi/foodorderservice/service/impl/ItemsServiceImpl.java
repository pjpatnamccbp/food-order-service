package com.abiruchi.foodorderservice.service.impl;

import com.abiruchi.foodorderservice.dto.ItemDto;
import com.abiruchi.foodorderservice.entity.ItemDetails;
import com.abiruchi.foodorderservice.excepion.ItemNotAvailableException;
import com.abiruchi.foodorderservice.excepion.ItemNotFoundException;
import com.abiruchi.foodorderservice.repository.ItemsRepository;
import com.abiruchi.foodorderservice.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;
    @Override
    public ItemDto saveItems(ItemDto itemDto) {
        ItemDetails savedItemDetails = itemsRepository.save(buildItemDetails(itemDto));
        ItemDto savedDto = buildItemDto(savedItemDetails);
        return savedDto;
    }



    @Override
    public List<ItemDto> getAllItems() {
        //List<ItemDto> itemsList = new ArrayList<>();
        List<ItemDetails> list = itemsRepository.findAll();
        List<ItemDto> itemsList = list.stream().map(item -> buildItemDto(item)).collect(Collectors.toList());
        return itemsList;
    }

    @Override
    public ItemDto getItemByName(String itemName) throws  ItemNotAvailableException {

        Optional<ItemDetails> optionalItemDetails = itemsRepository.findByItemName(itemName);

        //ItemDetails itemDetails = null;
//
        if(optionalItemDetails.isPresent()){
            //itemDetails = optionalItemDetails.get();
            return buildItemDto(optionalItemDetails.get());
        }else{
            throw new ItemNotAvailableException("item404","item not available at restaurent");
        }
//        return buildItemDto(optionalItemDetails.get());
    }


    private static ItemDto buildItemDto(ItemDetails savedItemDetails) {
        ItemDto itemDto = new ItemDto();

        itemDto.setItemId(savedItemDetails.getItemId());
        itemDto.setItemName(savedItemDetails.getItemName());
        itemDto.setPrice(savedItemDetails.getPrice());
        itemDto.setItemType(savedItemDetails.getItemType());
        itemDto.setDescription(savedItemDetails.getDescription());

        return itemDto;
    }

    private static ItemDetails buildItemDetails(ItemDto itemDto) {
        ItemDetails itemDetails = new ItemDetails();

        itemDetails.setItemName(itemDto.getItemName());
        itemDetails.setDescription(itemDto.getDescription());
        itemDetails.setPrice(itemDto.getPrice());
        itemDetails.setItemType(itemDto.getItemType());

        return itemDetails;
    }
}
