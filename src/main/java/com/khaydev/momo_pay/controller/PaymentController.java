package com.khaydev.momo_pay.controller;

import com.khaydev.momo_pay.model.Charge;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/pay")
@RequiredArgsConstructor
public class PaymentController {

    private final RestTemplate restTemplate;

    @Value("${charge.endpoint}")
    private String chargeUrl;

    @Value("${bearer.secret.key}")
    private String secret_key;
    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public ResponseEntity<String> pay(@RequestBody Charge charge){

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + secret_key);
        headers.set("Content-Type", "application/json");
        headers.set("Accept","application/json");
        HttpEntity<Charge> httpEntity = new HttpEntity<>(charge, headers);
        ResponseEntity<String> response = restTemplate.exchange(chargeUrl, HttpMethod.POST, httpEntity, String.class);

        return response;
    }
}
