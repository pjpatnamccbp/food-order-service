package com.abiruchi.foodorderservice.repository;

import com.abiruchi.foodorderservice.entity.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/
@Repository
public interface ItemsRepository extends JpaRepository<ItemDetails,Long> {

    Optional<ItemDetails> findByItemName(String itemName);
}
