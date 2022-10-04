package com.example.controller;


import com.example.dto.CustomerDto;
import com.example.dto.EmployeeDto;
import com.example.model.Customer;
import com.example.model.Employee;
import com.example.service.IDivisionService;
import com.example.service.IEducationDegreeService;
import com.example.service.IEmployeeService;
import com.example.service.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IDivisionService iDivisionService;

    @GetMapping("")
    public String showEmployeeSearch(@RequestParam(value = "name",defaultValue = "") String name,
                                     @RequestParam(value = "phone",defaultValue = "")String phone,
                                     @RequestParam(value = "idCard",defaultValue = "")String idCard,
                                     @PageableDefault(value = 5)Pageable pageable, Model model){
        model.addAttribute("employees",iEmployeeService.findByName(name,phone,idCard,pageable));
        model.addAttribute("name",name);
        model.addAttribute("phone",phone);
        model.addAttribute("idCard",idCard);
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
        model.addAttribute("positions", iPositionService.findAll());
        model.addAttribute("divisions",iDivisionService.findAll());
        return "employee/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
        model.addAttribute("positions", iPositionService.findAll());
        model.addAttribute("divisions",iDivisionService.findAll());
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {

//        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
//            model.addAttribute("positions", iPositionService.findAll());
//            model.addAttribute("divisions", iDivisionService.findAll());
//            return "employee/create";
//        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("messCreate", "Create Success !!");
            return "redirect:/employee";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        Employee employee = iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);

        model.addAttribute("employees", iEmployeeService.findById(id));
        model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
        model.addAttribute("positions", iPositionService.findAll());
        model.addAttribute("divisions", iDivisionService.findAll());
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("messUpdate", "Update Success!");
        return "redirect:/employee";
    }

//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("employees", iEmployeeService.findById(id));
//        model.addAttribute("educationDegrees",iEducationDegreeService.findAll());
//        model.addAttribute("positions",iPositionService.findAll());
//        model.addAttribute("divisions",iDivisionService.findAll());
//        return "employee/delete";
//    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "idDelete")int id, RedirectAttributes redirect) {
        iEmployeeService.remove(id);
        redirect.addFlashAttribute("messDelete", "Delete Success!");
        return "redirect:/employee";
    }
}
