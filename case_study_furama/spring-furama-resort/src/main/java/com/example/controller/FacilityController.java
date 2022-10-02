package com.example.controller;

import com.example.dto.FacilityDto;
import com.example.model.Facility;
import com.example.service.IFacilityService;
import com.example.service.IFacilityTypeService;
import com.example.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("")
    public String showFacility(@RequestParam(value = "name",defaultValue = "") String name,
            @PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Facility> facilityPage = iFacilityService.findAllByQuery(name,pageable);
        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("name",name);
        return "/facility/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        model.addAttribute("facilityDto", new FacilityDto());
        return "/facility/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("facilityDto") FacilityDto facilityDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);

        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("messCreate", "Create Success!!");
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Facility facility = iFacilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility, facilityDto);

        model.addAttribute("facilityDto", facilityDto);
        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        return "/facility/edit";
    }

    @PostMapping("/update")
    public String update(FacilityDto facilityDto, RedirectAttributes redirectAttributes) {
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        iFacilityService.update(facility);
        redirectAttributes.addFlashAttribute("messUpdate", "Update Success!!");
        return "redirect:/facility";
    }


//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
//        model.addAttribute("rentTypes", iRentTypeService.findAll());
//        model.addAttribute("facilitys", iFacilityService.findById(id));
//        return "/facility/delete";
//    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "idDelete") int id, RedirectAttributes redirectAttributes) {
        iFacilityService.remove(id);
        redirectAttributes.addFlashAttribute("messDelete", "Delete[" +
                iFacilityService.findById(id).getName() + "]  Success !!");
        return "redirect:/facility";
    }

}
