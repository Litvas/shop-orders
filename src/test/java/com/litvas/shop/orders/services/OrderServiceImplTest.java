package com.litvas.shop.orders.services;

import com.litvas.shop.orders.domain.Order;
import com.litvas.shop.orders.domain.OrderEntry;
import com.litvas.shop.orders.repositories.OrderRepository;
import com.litvas.shop.orders.utils.HashGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {
    private static final String HASH = "1111";
    private static final String ORDER_CODE = "orderCode";
    private static final Long ORDER_ID = 1L;

    @InjectMocks
    private OrderServiceImpl testedEntry;

    @Mock
    private HashGenerator randomHashGenerator;

    @Mock
    private OrderRepository orderRepository;

    private OrderEntry orderEntry = OrderEntry.builder().build();

    private Order order = Order.builder()
            .id(ORDER_ID)
            .code(ORDER_CODE)
            .entries(singletonList(orderEntry))
            .build();


    @Before
    public void setUp() {
        doReturn(HASH).when(randomHashGenerator).generate();
        doReturn(order).when(orderRepository).save(order);
        doReturn(order).when(orderRepository).getOrderByCode(ORDER_CODE);
    }

    @Test
    public void shouldSetUpHashWhenSetCodeToNewOrder() {
        testedEntry.addOrder(order);
        assertThat(order.getCode()).isSameAs("1111");
    }

    @Test
    public void shouldReturnOrderWhenNewOrderSaved() {
        assertThat(testedEntry.addOrder(order)).isSameAs(order);
    }

    @Test
    public void shouldSetUpOrderWhenUpdateOrder() {
        assertThat(testedEntry.updateOrder(order)).isSameAs(order);
    }

}
