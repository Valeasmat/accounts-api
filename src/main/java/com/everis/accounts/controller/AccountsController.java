package com.everis.accounts.controller;


import com.everis.accounts.dao.Account;
import com.everis.accounts.dao.AccountResponse;
import com.everis.accounts.service.AccountsService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @GetMapping(value = "/core/accounts",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Single<AccountResponse> getAccount(@RequestParam("cardNumber") String cardNumber){
        Single<Account> accountByCardNumber = accountsService.getAccount(cardNumber);
        Single<AccountResponse> response = accountByCardNumber
                .map(account -> {
                    Thread.sleep(5000);
                    return new AccountResponse(account.getAccountNumber(), account.getAmount());
                });

        return response;
    }
}
