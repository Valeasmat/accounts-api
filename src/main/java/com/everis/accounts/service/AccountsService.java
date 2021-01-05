package com.everis.accounts.service;


import com.everis.accounts.dao.Account;
import io.reactivex.Single;

public interface AccountsService {
    Single<Account> getAccount(String cardNumber);
}
