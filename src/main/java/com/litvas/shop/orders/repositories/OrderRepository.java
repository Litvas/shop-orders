package com.litvas.shop.orders.repositories;

import com.litvas.shop.orders.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order getOrderByCode(String orderCode);

    void deleteByCode(String code);

}
