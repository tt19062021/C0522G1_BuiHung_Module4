package com.example.controller;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/query")
    public String showBlogList(Model model){
        List<BlogDto> blogDtoList = iBlogService.findByQuery();
        model.addAttribute("blogDtoList",blogDtoList);
        return "/blog/list_query";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categorys", iCategoryService.findAll());
        model.addAttribute("blogList", new Blog());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog) {

        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("blogList", iBlogService.findById(id));
        return "/blog/view";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("blogList", iBlogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("messUpdate", "UPDATE SUCCESS!!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("blogList", iBlogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        iBlogService.remove(blog.getId());
        redirect.addFlashAttribute("messDelete", "REMOVE SUCCESS!!");
        return "redirect:/blog";
    }

    @GetMapping("/blog")
    public String search(@RequestParam(defaultValue = "") String name,
                         @PageableDefault(value = 5,sort = "date_of_writing", direction = Sort.Direction.DESC)
                                 Pageable pageable,
                         Model model) {
        model.addAttribute("blogList", iBlogService.findTitleName(name, pageable));

        model.addAttribute("name", name);
        return "/blog/list";
    }



}
