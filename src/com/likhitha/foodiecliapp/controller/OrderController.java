package com.likhitha.foodiecliapp.controller;

import com.likhitha.foodiecliapp.exceptions.OrderExistsException;
import com.likhitha.foodiecliapp.exceptions.OrderNotFoundException;
import com.likhitha.foodiecliapp.model.Order;
import com.likhitha.foodiecliapp.service.OrderServiceImpl;

import java.util.List;

public class OrderController {

    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    public List<Order> getOrdersList(){
        return this.orderService.getOrdersList();
    }

    public Order getOrderById(String id) throws OrderNotFoundException {
        return this.orderService.getOrderById(id);
    }

    public Order saveOrder(Order order) throws OrderExistsException {
        return this.orderService.save(order);
    }
}
