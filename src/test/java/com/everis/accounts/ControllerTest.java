package com.everis.accounts;

import com.everis.accounts.controller.AccountsController;
import com.everis.accounts.dto.Account;
import com.everis.accounts.dto.AccountResponse;
import com.everis.accounts.service.AccountsService;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private AccountsController controller;

    @Mock
    private AccountsService service;


    @Test
    public void getAccountTest(){
        Single<Account> response=Single.just(new Account("1111222233334441XXX",1000L));

        Mockito.when(service.getAccount(Mockito.anyString())).thenReturn(response);

        TestObserver<AccountResponse> test=controller.getAccount("1111222233334441").test();

        test.assertValueCount(1)
                .assertNever(a->!a.getAccountNumber().endsWith("XXX"))
                .assertNever(a->a.getAmount()!=1000L)
                .assertNoErrors();
    }
}
