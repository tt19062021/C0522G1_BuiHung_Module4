package codegym.controller;

import codegym.model.Customer;
import codegym.repository.ICustomerRepository;
import codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/customers")
    public  String showCus(ModelMap modelMap){
        List<Customer> customerList = iCustomerService.findAll();
        modelMap.addAttribute("customerList",customerList);
        return "list";
    };
}
