package com.litvas.shop.orders.controllers;

import com.litvas.shop.orders.domain.Order;
import com.litvas.shop.orders.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping
    public void deleteOrder(@RequestParam String code) {
        orderService.deleteOrder(code);
    }
}
