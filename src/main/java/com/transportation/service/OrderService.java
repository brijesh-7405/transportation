package com.transportation.service;

import com.transportation.entity.Order;
import com.transportation.entity.User;

import java.util.List;

public interface OrderService {
    Long createOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(Long orderId);

    Order updateOrder(Long orderId, Order user);

    void deleteOrder(Long orderId);
}
