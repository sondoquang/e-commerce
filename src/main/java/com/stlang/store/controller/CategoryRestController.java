package com.stlang.store.controller;

import com.stlang.store.domain.Category;
import com.stlang.store.exception.DataNotFoundException;
import com.stlang.store.response.APIResponse;
import com.stlang.store.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v01")
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/categories")
    public ResponseEntity<APIResponse> getCategories() {
       List<Category> categories = categoryService.findAll();
       return ResponseEntity.ok(new APIResponse("success", categories));
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<APIResponse> getCategory(@PathVariable int id) {
        try {
            Category category = categoryService.findById(id);
            return ResponseEntity.ok(new APIResponse("Success", category));
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(BAD_REQUEST).body(new APIResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/categories")
    public ResponseEntity<APIResponse> addCategory(@RequestBody Category category) {
        try {
            categoryService.create(category);
            return ResponseEntity.ok(new APIResponse("Create success", category));
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new APIResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<APIResponse> updateCategory(@PathVariable int id, @RequestBody String category) {
        try {
            categoryService.update(category, id);
            return ResponseEntity.ok(new APIResponse("Update success", category));
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(BAD_REQUEST).body(new APIResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<APIResponse> deleteCategory(@PathVariable Integer id) {
        try {
            categoryService.delete(id);
            return ResponseEntity.ok(new APIResponse("Delete category success", null));
        } catch (Exception e) {
            return ResponseEntity.status(BAD_REQUEST).body(new APIResponse(e.getMessage(), null));
        }
    }

}
