package com.everis.accounts;

import com.everis.accounts.dto.Account;
import com.everis.accounts.service.impl.AccountsServiceImpl;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @InjectMocks
    private AccountsServiceImpl accountsService;

    @Test
    public void getAccountTest(){

        TestObserver<Account> test=accountsService.getAccount("1111222233334441").test();

        test.assertNoErrors()
                .assertValueCount(1)
                .assertNever(a->a.getAmount()!=1000L);

        TestObserver<Account> test2=accountsService.getAccount("1111222233334442").test();

        test2.assertNoErrors()
                .assertValueCount(1)
                .assertNever(a->a.getAmount()!=500L);

        TestObserver<Account> test3=accountsService.getAccount("1111222233334443").test();

        test3.assertNoErrors()
                .assertValueCount(1)
                .assertNever(a->a.getAmount()!=1500L);
    }
}
