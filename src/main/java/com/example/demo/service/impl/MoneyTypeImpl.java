package com.example.demo.service.impl;

import com.example.demo.model.MoneyType;
import com.example.demo.repository.MoneyTypeRepository;
import com.example.demo.service.MoneyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoneyTypeImpl implements MoneyTypeService {
    @Autowired
    MoneyTypeRepository moneyTypeRepository;

    @Override
    public Page<MoneyType> findAll(Pageable pageable) {
        return moneyTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<MoneyType> findById(Long id) {
        return moneyTypeRepository.findById(id);
    }

    @Override
    public Iterable<MoneyType> findAll() {
        return moneyTypeRepository.findAll();
    }

    @Override
    public void save(MoneyType moneyType) {
        moneyTypeRepository.save(moneyType);
    }

    @Override
    public void remove(Long id) {
        moneyTypeRepository.deleteById(id);
    }
}
