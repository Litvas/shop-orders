package com.litvas.shop.orders.repositories;

import com.litvas.shop.orders.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
