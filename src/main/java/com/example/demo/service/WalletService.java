package com.example.demo.service;

import com.example.demo.model.Wallet;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface WalletService extends Service<Wallet> {
    Iterable<Wallet> findAllByNameContaining(String name);
    Iterable<Wallet> findAllByStatusPublicAndUser_Id(@Param("id") Long id);
    Iterable<Wallet> findAllByStatusPrivateAndUser_Id(@PathVariable Long id);
/*    Optional<Wallet> deleteByUserId(@Param("id") Long id, @Param("userId") Long userId);*/


}
