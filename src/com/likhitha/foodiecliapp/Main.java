package com.likhitha.foodiecliapp;

import com.likhitha.foodiecliapp.ui.Menu;

public class Main {
    public static void main(String[] args) {
       /* CSVReader csvReader=new CSVReader();
        System.out.println(csvReader.readCustomerFromCsv()); */
        /*CustomerRepository customerRepository=new CustomerRepository();
        System.out.println(customerRepository.getAllCustomers());*/
        Menu menu=new Menu();
        menu.displayMenu();
    }
}
