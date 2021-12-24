package com.litvas.shop.orders.services;

import com.litvas.shop.orders.domain.Delivery;
import com.litvas.shop.orders.domain.DeliveryStatus;
import com.litvas.shop.orders.repositories.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeliveryServiceImpl implements DeliveryService{

    private DeliveryRepository deliveryRepository;

    @Override
    public Delivery addDeliveryInfo(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }
}
