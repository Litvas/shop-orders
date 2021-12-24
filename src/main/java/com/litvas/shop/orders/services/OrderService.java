package com.litvas.shop.orders.services;

import com.litvas.shop.orders.domain.Order;

public interface OrderService {

    Order addOrder(Order order);

    void deleteOrder(String code);

    Order updateOrder(Order order);

}
