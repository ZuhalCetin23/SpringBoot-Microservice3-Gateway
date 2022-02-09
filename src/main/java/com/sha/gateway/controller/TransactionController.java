package com.sha.gateway.controller;

import com.google.gson.JsonElement;
import com.sha.gateway.model.service.AbstractProductService;
import com.sha.gateway.model.service.AbstractTransactionService;
import com.sha.gateway.security.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("gateway/transaction")
@RestController
public class TransactionController {

    @Autowired
    private AbstractTransactionService transactionService;

    @GetMapping
    public ResponseEntity<?>getAllTransactionOfAuthorizedUser(@AuthenticationPrincipal UserPrinciple userPrinciple)
    {
        return ResponseEntity.ok(transactionService.getAllTransactionOfUser(userPrinciple.getId()));
    }

    @DeleteMapping("{transactionID}")
    public ResponseEntity<?> delete(@PathVariable Integer transactionID)
    {
        transactionService.deleteByID(transactionID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody JsonElement transaction)
    {
        return ResponseEntity.ok(transactionService.save(transaction));
    }
}
