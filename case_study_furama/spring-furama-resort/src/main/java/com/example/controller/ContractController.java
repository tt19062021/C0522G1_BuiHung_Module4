package com.example.controller;

import com.example.dto.ContractDto;
import com.example.dto.CustomerDto;
import com.example.model.Contract;
import com.example.model.Customer;
import com.example.service.IAttachFacilityService;
import com.example.service.IContractDetailService;
import com.example.service.IContractService;
import com.example.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("")
    public String showContract(@PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("contracts",iContractService.findAll(pageable));

        return "contract/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

//        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("customerTypes", iCustomerTypeService.findAll());
//            return "customer/create";
//        } else {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("messCreate", "Create Success!!");
        return "redirect:/contract";
    }
}
