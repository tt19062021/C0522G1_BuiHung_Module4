package com.example.controller;

import com.example.model.Customer;

import com.example.service.ICustomerService;
import com.example.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IProvinceService iProvinceService;

    @GetMapping({"/"})
    public String showCustomers(@PageableDefault(value = 2) Pageable pageable, Model model){
        Page<Customer> customerList = iCustomerService.findAll(pageable);
        model.addAttribute("customerList",customerList);
        model.addAttribute("provinceList",iProvinceService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("provinceList",iProvinceService.findAll());
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/";
    }
}
