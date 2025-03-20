package com.stlang.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCardController {
    @GetMapping("/cart/view")
    public String detail( Model model) {
        return "cart/view";
    }
}
