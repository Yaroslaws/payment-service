package com.example.payment_service.controller;

import com.example.payment_service.dto.PaymentDto;
import com.example.payment_service.dto.SubscriberPaymentsDto;
import com.example.payment_service.service.PaymentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentsController {

    private final PaymentsService paymentsService;

    @GetMapping
    public Flux<SubscriberPaymentsDto> payment() {
         return paymentsService.getPayments();
    }

    @PostMapping
    public void create(@RequestBody PaymentDto paymentDto) {
        paymentsService.createPayment(paymentDto);
    }
}
