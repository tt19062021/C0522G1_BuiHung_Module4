package codegym.repository;

import codegym.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
}
