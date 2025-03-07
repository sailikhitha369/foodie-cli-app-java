package com.likhitha.foodiecliapp.repository;

import com.likhitha.foodiecliapp.factory.Factory;
import com.likhitha.foodiecliapp.model.Restaurant;

import java.util.List;
import java.util.Optional;

public class RestaurantRepository {

    private List<Restaurant> restaurantList;

    public RestaurantRepository() {
        this.restaurantList = Factory.getCsvReader().readRestaurantsFromCsv();
    }

    public List<Restaurant> getRestaurantList(){
        return this.restaurantList;
    }

    public Restaurant save(Restaurant restaurant){ this.restaurantList.add(restaurant); return restaurant; }

    public Optional<Restaurant> findRestaurantById(String id) {
        return this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(id)).findFirst();
    }

    public Restaurant updateRetaurant(Restaurant restaurantToBeUpdated){
        Optional<Restaurant> restaurantOptional = this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(restaurantToBeUpdated.getId()))
                .findFirst()
                .map(restaurant -> {
                    restaurant.setName(restaurantToBeUpdated.getName())
                            .setAddress(restaurantToBeUpdated.getAddress())
                            .setMenu(restaurantToBeUpdated.getMenu());
                    return restaurant;
                });
        return restaurantOptional.orElse(null);
    }

    public void deleteRestaurant(Restaurant restaurant){
        this.restaurantList.remove(restaurant);
    }
}
