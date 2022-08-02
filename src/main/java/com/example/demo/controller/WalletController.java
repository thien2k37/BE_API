package com.example.demo.controller;

import com.example.demo.model.Wallet;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.service.impl.WalletImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/wallets")
public class WalletController {
    @Autowired
    WalletImpl walletService;

    @Autowired
    UserServiceImpl userService;
    @GetMapping
    public ResponseEntity<Iterable<Wallet>> findAllByStatusPublicAndUser_Id(@RequestParam Long id) {
        return new ResponseEntity<>(walletService.findAllByStatusPublicAndUser_Id(id), HttpStatus.OK);
    }
    @GetMapping("/history/{id}")
    public ResponseEntity<Iterable<Wallet>> findAllByStatusPrivateAndUser_Id(@PathVariable Long id) {
        return new ResponseEntity<>(walletService.findAllByStatusPrivateAndUser_Id(id), HttpStatus.OK) ;
    }
    @GetMapping("/find-by-name")
    public ResponseEntity<Iterable<Wallet>> findAllByNameContaining(@RequestParam String name) {
        return new ResponseEntity<>(walletService.findAllByNameContaining(name), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Wallet>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(walletService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Optional<Wallet>> save(@RequestBody Wallet wallet) {
        wallet.setStatus(1);
        walletService.save(wallet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Wallet> DeleteWallet(@PathVariable Long id,Wallet wallet) {
        Optional<Wallet> walletDelete = this.walletService.findById(id);
        if (!walletDelete.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        walletDelete.get().setStatus(2);
        wallet.setId(walletDelete.get().getId());
        wallet.setName(walletDelete.get().getName());
        wallet.setIcon(walletDelete.get().getIcon());
        wallet.setTotalMoney(walletDelete.get().getTotalMoney());
        wallet.setMoneyType(walletDelete.get().getMoneyType());
        wallet.setUser(walletDelete.get().getUser());
        wallet.setStatus(walletDelete.get().getStatus());
        walletService.save(wallet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Wallet> updateWallet(@PathVariable Long id, @RequestBody Wallet wallet) {
        Optional<Wallet> walletEdit = this.walletService.findById(id);
        if (!walletEdit.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        wallet.setId(walletEdit.get().getId());
        walletService.save(wallet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
