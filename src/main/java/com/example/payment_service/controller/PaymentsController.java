package com.example.payment_service.controller;

import com.example.payment_service.dto.PaymentDto;
import com.example.payment_service.dto.SubscriberPaymentsDto;
import com.example.payment_service.kafka.KafkaProducerService;
import com.example.payment_service.service.PaymentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@Slf4j
public class PaymentsController {

    private final PaymentsService paymentsService;
    private final KafkaProducerService kafkaProducerService;

    @GetMapping
    public Flux<SubscriberPaymentsDto> payment() {
        log.info("get payment");
        return paymentsService.getPayments();
    }

    @PostMapping
    public void create(@RequestBody PaymentDto paymentDto) {
        log.info("create payment: {}", paymentDto.toString());
        kafkaProducerService.send(paymentDto.toString());
        paymentsService.createPayment(paymentDto);
    }
}
