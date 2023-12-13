package com.abiruchi.foodorderservice.controller;

import com.abiruchi.foodorderservice.dto.ItemDto;
import com.abiruchi.foodorderservice.excepion.ItemNotAvailableException;
import com.abiruchi.foodorderservice.excepion.ItemNotFoundException;
import com.abiruchi.foodorderservice.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/

@RestController
@RequestMapping("/api/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @PostMapping("/save")
    public ItemDto saveItems(@RequestBody ItemDto itemDto){
        return itemsService.saveItems(itemDto);
    }

    @GetMapping("/{itemName}")
    public ItemDto getItemByName(@PathVariable String itemName) throws ItemNotAvailableException {
        return itemsService.getItemByName(itemName);
    }

    @GetMapping
    @ResponseBody
    public List<ItemDto> getAll(){
        return itemsService.getAllItems();
    }
}
