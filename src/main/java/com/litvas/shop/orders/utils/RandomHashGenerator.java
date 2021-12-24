package com.litvas.shop.orders.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomHashGenerator implements HashGenerator {

    public String generate() {
        return UUID.randomUUID().toString();
    }

}
