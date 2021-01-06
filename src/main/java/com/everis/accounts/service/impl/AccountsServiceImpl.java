package com.everis.accounts.service.impl;

import com.everis.accounts.dto.Account;
import com.everis.accounts.service.AccountsService;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountsServiceImpl implements AccountsService {
    @Override
    public Single<Account> getAccount(String cardNumber) {
        Account account=new Account();
        account.setAccountNumber(cardNumber+"XXX");
        Map<Character,Long> map=new HashMap<>();
        map.put('1',1000L);
        map.put('2',500L);
        map.put('3',1500L);
        map.put('4',1200L);
        map.put('5',1600L);
        map.put('6',1700L);

        account.setAmount(map.get(cardNumber.charAt(15)));
        return Single.just(account);
    }
}
