package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.impl.CategoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/Categories")
public class CategoryController {
    @Autowired
    CategoryImpl categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Optional<Category>> save(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Category>> delete(@PathVariable Long id) {
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> categoryUpdate = this.categoryService.findById(id);
        if (!categoryUpdate.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(categoryUpdate.get().getId());
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
