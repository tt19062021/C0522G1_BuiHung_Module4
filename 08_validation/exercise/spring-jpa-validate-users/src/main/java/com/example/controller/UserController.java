package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String showList(Model model) {
        List<User> userList = iUserService.findByAll();
        model.addAttribute("userList", userList);
        return "/user/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/user/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("userDto") @Validated UserDto userDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/user/create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);

            iUserService.save(user);
            redirectAttributes.addFlashAttribute("success", "Create Success!!");
            return "redirect:/";
        }

    }
}
