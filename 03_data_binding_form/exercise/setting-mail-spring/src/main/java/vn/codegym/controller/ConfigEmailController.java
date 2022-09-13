package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.ConfigEmail;
import vn.codegym.service.IConfigEmailService;

import java.util.ArrayList;
import java.util.List;

@Controller

public class ConfigEmailController {

    @Autowired
    private IConfigEmailService iConfigEmailService;

    @GetMapping("/email")
    public String listDefaultEmail(Model model) {
        List<ConfigEmail> configEmails = iConfigEmailService.findAll();
        model.addAttribute("configEmails", configEmails);
        return "list";
    }

    @GetMapping("/email/update")
    public String showInfoSetting(@RequestParam int id, Model model) {
        ConfigEmail configEmail = iConfigEmailService.findById(id);
        model.addAttribute("languageList", iConfigEmailService.listLanguage());
        model.addAttribute("pageSizeList", iConfigEmailService.listPageSize());
        model.addAttribute("configEmail", configEmail);
        return "setting";
    }

    @PostMapping("/email/save")
    public String save(@ModelAttribute ConfigEmail configEmail, RedirectAttributes redirectAttributes) {
        iConfigEmailService.update(configEmail);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/email";
    }
}
