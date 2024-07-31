package com.likhitha.foodiecliapp.repository;

import com.likhitha.foodiecliapp.factory.Factory;
import com.likhitha.foodiecliapp.model.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    List<Customer> customersList;

    public CustomerRepository() {
        this.customersList = Factory.getCsvReader().readCustomersFromCsv();
    }

    public List<Customer> getCustomersList() {
        return this.customersList;
    }

    public Customer saveCustomer(Customer customer) {
        this.customersList.add(customer);
        return customer;
    }

    public Optional<Customer> findCustomerById(String id) {
        return this.customersList.stream().filter(customer -> customer.getCustomerId().equals(id)).findFirst();
    }

    public Optional<Customer> findCustomerByEmail(String email){
        return this.customersList.stream().filter(customer -> customer.getEmail().equals(email)).findFirst();
    }

    public Customer updateCustomer(Customer customerToBeUpdated) {
        Optional<Customer> updateCustomer =  this.customersList.stream().filter(customer -> customer.getCustomerId().equals(customerToBeUpdated.getCustomerId()))
                .findFirst()
                .map(customer -> {
                    customer.setName(customerToBeUpdated.getName())
                            .setEmail(customerToBeUpdated.getEmail())
                            .setPassword(customerToBeUpdated.getPassword());

                    return customer;
                });
        return updateCustomer.orElse(null);

    }

    public void deleteCustomer(Customer customer){
        this.customersList.remove(customer);
    }

    public Optional<Customer> findByEmailAndPassword(String email, String password){
        return this.customersList.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email) && customer.getPassword().equals(password)).findFirst();
    }
}