package com.likhitha.foodiecliapp.service;

import com.likhitha.foodiecliapp.exceptions.OrderExistsException;
import com.likhitha.foodiecliapp.exceptions.OrderNotFoundException;
import com.likhitha.foodiecliapp.model.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getOrdersList();
    public Order getOrderById(String id) throws OrderNotFoundException;
    public Order save(Order order) throws OrderExistsException;


}