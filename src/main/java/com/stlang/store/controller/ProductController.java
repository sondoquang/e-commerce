package com.stlang.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @GetMapping("/product/list")
    public String list() {
        return "product/list";
    }

    @GetMapping("/product/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        return "product/detail";
    }

}
