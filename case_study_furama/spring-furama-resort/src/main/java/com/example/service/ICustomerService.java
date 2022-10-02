package com.example.service;


import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    Page<Customer> findByName(String name, String phone, String address, Pageable pageable);

    Customer findById(int id);

    void save(Customer customer);

    void update(Customer customer);

    void remove(int id);
}
