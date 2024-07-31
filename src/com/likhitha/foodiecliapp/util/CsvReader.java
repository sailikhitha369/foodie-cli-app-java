package com.likhitha.foodiecliapp.util;

import com.likhitha.foodiecliapp.model.Customer;
import com.likhitha.foodiecliapp.model.Dish;
import com.likhitha.foodiecliapp.model.Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CsvReader {

    private List<Dish> dishesList;

    public List<Dish> readDishesFromCsv() {
        String DISHES_CSV_PATH = "C:\\Users\\Welcome\\IdeaProjects\\Foodie-CLI-App-Java\\data\\dishes.csv";
        String line;
        List<Dish> dishesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DISHES_CSV_PATH))) {
            String cvsSplitBy = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Dish dish = new Dish();
                dish.setId(data[0])
                        .setName(data[1])
                        .setDescription(data[2])
                        .setPrice(Double.parseDouble(data[3]));
                dishesList.add(dish);
            }
            this.dishesList = dishesList;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path :" + DISHES_CSV_PATH);
            System.exit(0);
        }
        return dishesList;
    }

    public List<Customer> readCustomersFromCsv() {
        String CUSTOMERS_CSV_PATH = "C:\\Users\\Welcome\\IdeaProjects\\Foodie-CLI-App-Java\\data\\customers.csv";
        String line;
        List<Customer> customersList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMERS_CSV_PATH))) {
            String cvsSplitBy = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Customer customer = new Customer();
                customer.setId(data[0])
                        .setName(data[1])
                        .setEmail(data[2])
                        .setPassword(data[3]);
                customersList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path :" + CUSTOMERS_CSV_PATH);
            System.exit(0);
        }
        return customersList;
    }

    public List<Restaurant> readRestaurantsFromCsv() {
        String RESTAURANTS_CSV_PATH = "C:\\Users\\Welcome\\IdeaProjects\\Foodie-CLI-App-Java\\data\\restaurants.csv";
        String line;
        List<Restaurant> restaurantsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RESTAURANTS_CSV_PATH))) {
            String cvsSplitBy = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Restaurant restaurant = new Restaurant();

                restaurant.setId(data[0])
                        .setName(data[1])
                        .setAddress(data[2])
                        .setMenu(Arrays.asList(data[3].split(":")));
                restaurantsList.add(restaurant);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path :" + RESTAURANTS_CSV_PATH);
            System.exit(0);
        }
        return restaurantsList;
    }
}