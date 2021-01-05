package com.everis.accounts.dao;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
    private String accountNumber;
    private Long amount;
}
