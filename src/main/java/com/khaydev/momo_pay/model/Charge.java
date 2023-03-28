package com.khaydev.momo_pay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Charge {

    private double amount;
    private String email;
    private String currency;

    @JsonProperty("mobile_money")
    private MobileMoney mobileMoney;

}
