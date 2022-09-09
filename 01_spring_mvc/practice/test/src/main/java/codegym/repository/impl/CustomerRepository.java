package codegym.repository.impl;

import codegym.model.Customer;
import codegym.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {


    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "hung", "@gmail.com", "Danang"));

    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
