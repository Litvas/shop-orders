package com.litvas.shop.orders.services;

import com.litvas.shop.orders.domain.Delivery;

// Bad practice for microservices. Maybe I will refactor this to Kafka
public interface DeliveryService {

    Delivery addDeliveryInfo(Delivery delivery);

}
