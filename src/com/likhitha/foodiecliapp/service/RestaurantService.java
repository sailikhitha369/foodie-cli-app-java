package com.likhitha.foodiecliapp.service;

import com.likhitha.foodiecliapp.exceptions.DishNotFoundException;
import com.likhitha.foodiecliapp.exceptions.RestaurantExistsException;
import com.likhitha.foodiecliapp.exceptions.RestaurantNotFoundException;
import com.likhitha.foodiecliapp.model.Dish;
import com.likhitha.foodiecliapp.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public List<Restaurant> getRestaurantList();
    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException;

    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException;

    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;

    public void deleteRestaurant(String id) throws RestaurantNotFoundException;

    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException;
}