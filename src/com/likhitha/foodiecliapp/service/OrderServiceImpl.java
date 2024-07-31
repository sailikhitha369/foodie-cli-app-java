package com.likhitha.foodiecliapp.service;

import com.likhitha.foodiecliapp.exceptions.OrderExistsException;
import com.likhitha.foodiecliapp.exceptions.OrderNotFoundException;
import com.likhitha.foodiecliapp.model.Order;
import com.likhitha.foodiecliapp.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }



    @Override
    public List<Order> getOrdersList() {
        return this.orderRepository.getOrderList();
    }

    @Override
    public Order getOrderById(String id) throws OrderNotFoundException {
        Optional<Order> orderById = this.orderRepository.findOrderById(id);
        if(orderById.isEmpty())
            throw new OrderNotFoundException("Order Not Found with Id : " + id);
        return orderById.get();
    }

    @Override
    public Order save(Order order) throws OrderExistsException {
        Optional<Order> orderById = this.orderRepository.findOrderById(order.getId());
        if(orderById.isPresent())
            throw new OrderExistsException("Order Already Exists with this Id : " + order.getId());
        return this.orderRepository.save(order);
    }
}
