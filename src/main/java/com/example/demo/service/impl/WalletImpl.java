package com.example.demo.service.impl;

import com.example.demo.model.Wallet;
import com.example.demo.repository.WalletRepository;
import com.example.demo.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletImpl implements WalletService {
    @Autowired
    WalletRepository walletRepository;
    @Override
    public Page<Wallet> findAll(Pageable pageable) {
        return walletRepository.findAll(pageable);
    }

    @Override
    public Optional<Wallet> findById(Long id) {
        return walletRepository.findById(id);
    }

    @Override
    public Iterable<Wallet> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public void save(Wallet wallet) {
        walletRepository.save(wallet);
    }

    @Override
    public void remove(Long id) {
        walletRepository.deleteById(id);
    }

    @Override
    public Iterable<Wallet> findAllByNameContaining(String name) {
        return walletRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Wallet> findAllByStatusPublicAndUser_Id(Long id) {
        return walletRepository.findAllByStatusPublicAndUser_Id(id);
    }

    @Override
    public Iterable<Wallet> findAllByStatusPrivateAndUser_Id(Long id) {
        return walletRepository.findAllByStatusPrivateAndUser_Id(id);
    }


}
