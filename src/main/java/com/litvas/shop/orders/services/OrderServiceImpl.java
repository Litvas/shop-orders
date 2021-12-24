package com.litvas.shop.orders.services;

import com.litvas.shop.orders.domain.Order;
import com.litvas.shop.orders.repositories.OrderRepository;
import com.litvas.shop.orders.utils.HashGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private HashGenerator hashGenerator;

    @Override
    public Order addOrder(Order order) {
        order.getEntries().forEach(entry -> entry.setOrder(order));
        order.setCode(hashGenerator.generate());
        return orderRepository.save(order);
    }

    public void deleteOrder(String code) {
        orderRepository.deleteByCode(code);
    }

    @Override
    @Transactional
    public Order updateOrder(Order order) {
        Order persistedOrder = orderRepository.getOrderByCode(order.getCode());
        persistedOrder.setEntries(order.getEntries());
        return orderRepository.save(persistedOrder);
    }

}
