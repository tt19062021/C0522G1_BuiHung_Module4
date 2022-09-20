package com.example.controller;

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


@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

//    @GetMapping({"/blog","/"})
//    public String showBlogList(Model model){
//        List<Blog> blogList = iBlogService.findByAll();
//        model.addAttribute("blogList",blogList);
//        return "list";
//    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categorys", iCategoryService.findByAll());
        model.addAttribute("blogList", new Blog());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog) {
//        blog.setId((int)(Math.random() * 200));
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findByAll());
        model.addAttribute("blogList", iBlogService.findById(id));
        return "/blog/view";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findByAll());
        model.addAttribute("blogList", iBlogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("messegerUpdate", "UPDATE SUCCESS!!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findByAll());
        model.addAttribute("blogList", iBlogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        iBlogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/blog")
    public String search(@PageableDefault(value = 3, sort = "dateOfWriting",
            direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam(value = "name", defaultValue = "") String name, Model model) {
        model.addAttribute("blogList", iBlogService.findAllByTitle(name, pageable));
        model.addAttribute("name", name);
        return "/blog/list";
    }


}
