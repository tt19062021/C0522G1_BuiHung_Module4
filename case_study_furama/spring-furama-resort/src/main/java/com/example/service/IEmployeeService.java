package com.example.service;


import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    Page<Employee> findByName(String name, String phone, String idCard, Pageable pageable);

    Employee findById(int id);

    void save(Employee employee);

    List<Employee> findAll();

    void remove(int id);
}
