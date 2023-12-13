package com.abiruchi.foodorderservice.repository;

import com.abiruchi.foodorderservice.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hp ON 09-06-2023
 * @Description
 **/

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails,Long> {
}
