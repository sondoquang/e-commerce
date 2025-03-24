package com.stlang.store.rest.controller;

import com.stlang.store.entity.Product;
import com.stlang.store.exception.DataNotFoundException;
import com.stlang.store.response.APIResponse;
import com.stlang.store.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v01")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/products", "/products/category/{id}"})
    public ResponseEntity<List<Product>> getProducts(@PathVariable Optional<Integer> id) {
        List<Product> products = id.isPresent() ? productService.findAll(id.get()): productService.findAll();
        return products.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(products, HttpStatus.OK);

    }

    @GetMapping("/products/{id}")
    public ResponseEntity<APIResponse> getProduct(@PathVariable int id) {
        try {
            Product product = productService.findById(id);
            return ResponseEntity.ok(new APIResponse("Success", product));
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(BAD_REQUEST).body(new APIResponse(e.getMessage(), null));
        }
    }
}
