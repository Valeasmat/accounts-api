package com.everis.accounts.service;


import com.everis.accounts.dto.Account;
import io.reactivex.Single;

public interface AccountsService {
    Single<Account> getAccount(String cardNumber);
}
