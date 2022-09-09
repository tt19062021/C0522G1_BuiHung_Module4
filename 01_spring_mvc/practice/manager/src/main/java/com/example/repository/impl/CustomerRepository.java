package com.example.repository.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customers;


    static {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "Hung Vip", "hung@gmail.com", "Da Nang"));
        customers.add(new Customer(2, "Huan Vip", "huan@gmail.com", "Da Nang"));
        customers.add(new Customer(2, "An Vip", "an@gmail.com", "Campuchia "));

    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

}
