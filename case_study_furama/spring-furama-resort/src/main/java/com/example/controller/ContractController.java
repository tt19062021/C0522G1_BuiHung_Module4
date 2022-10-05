package com.example.controller;

import com.example.dto.ContractDetailDto;
import com.example.dto.ContractDto;
import com.example.dto.CustomerDto;
import com.example.model.Contract;
import com.example.model.ContractDetail;
import com.example.model.Customer;
import com.example.service.*;
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
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String showContract(@PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("contracts",iContractService.findAll(pageable));
        model.addAttribute("contractDetails",iContractDetailService.findAll());
        model.addAttribute("attachFacilitys",iAttachFacilityService.findAll());
        model.addAttribute("employees",iEmployeeService.findAll());
        model.addAttribute("facilitys",iFacilityService.findAll());
        model.addAttribute("customers",iCustomerService.findAll());
        model.addAttribute("contractDto",new ContractDto());
        return "contract/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated ContractDto contractDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,Pageable pageable, Model model) {
        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("contracts", iContractService.findAll(pageable));
            return "contract/list";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            iContractService.save(contract);
            redirectAttributes.addFlashAttribute("messCreate", "Create Success!!");
            return "redirect:/contract";
        }
    }
}
