package com.example.service;


import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<Employee> findByName(String name, String phone, String idCard, Pageable pageable);

    Employee findById(int id);

    void save(Employee employee);

    void remove(int id);
}
