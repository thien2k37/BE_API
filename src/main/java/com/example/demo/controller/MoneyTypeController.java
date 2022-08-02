package com.example.demo.controller;

import com.example.demo.model.MoneyType;
import com.example.demo.service.impl.MoneyTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/money-types")
public class MoneyTypeController {
    @Autowired
    MoneyTypeImpl moneyType;

    @GetMapping
    public ResponseEntity<Iterable<MoneyType>> findAll() {
        return new ResponseEntity<>(moneyType.findAll(), HttpStatus.OK);
    }
}
