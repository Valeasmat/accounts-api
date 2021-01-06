package com.everis.accounts.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("Account response")
public class AccountResponse {
    @ApiModelProperty(example = "1111222233334441XXX")
    private String accountNumber;
    @ApiModelProperty(example = "1000")
    private Long amount;
}
