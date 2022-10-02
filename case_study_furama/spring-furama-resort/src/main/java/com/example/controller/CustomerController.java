package com.example.controller;


import com.example.dto.CustomerDto;
import com.example.model.Customer;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
        public String search(@RequestParam(value = "name" , defaultValue = "") String name,
                         @RequestParam(value = "phone" , defaultValue = "") String phone,
                         @RequestParam(value = "address" , defaultValue = "") String address,
                         @PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("customers", iCustomerService.findByName(name,phone,address, pageable));
        model.addAttribute("name", name);
        model.addAttribute("phone", name);
        model.addAttribute("address", address);
        return "customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerTypes", iCustomerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypes", iCustomerTypeService.findAll());
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("masseNew", "successfully added new !!");
            return "redirect:/customer";
        }
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customers", iCustomerService.findById(id));
        model.addAttribute("customerTypes", iCustomerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("messa", "edit successfully!");
        return "redirect:/customer";
    }

//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("customers", iCustomerService.findById(id));
//        model.addAttribute("customerTypes", iCustomerTypeService.findAll());
//        return "customer/delete";
//    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "idDelete")int id, RedirectAttributes redirect) {
        iCustomerService.remove(id);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customers", iCustomerService.findById(id));
        return "customer/view";
    }
}
