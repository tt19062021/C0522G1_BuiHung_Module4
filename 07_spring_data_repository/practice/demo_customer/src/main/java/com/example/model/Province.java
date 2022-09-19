package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity

public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameProvince;

    @OneToMany(mappedBy = "province")
    private Set<Customer> customers;

    public Province() {
    }

    public Province(int id, String nameProvince, Set<Customer> customers) {
        this.id = id;
        this.nameProvince = nameProvince;
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int provinceId) {
        this.id = provinceId;
    }

    public String getNameProvince() {
        return nameProvince;
    }

    public void setNameProvince(String nameProvince) {
        this.nameProvince = nameProvince;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
