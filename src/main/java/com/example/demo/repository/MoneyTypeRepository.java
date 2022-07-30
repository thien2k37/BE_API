package com.example.demo.repository;

import com.example.demo.model.MoneyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyTypeRepository extends JpaRepository<MoneyType, Long> {
}
