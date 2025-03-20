package com.stlang.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @RequestMapping("/order/checkout")
    public String detail( Model model) {
        return "order/checkout";
    }

    @GetMapping("/order/list")
    public String list( Model model) {
        return "order/list";
   }

    @RequestMapping("/order/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        return "order/detail";
    }
}
