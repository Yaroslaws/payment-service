package com.example.payment_service.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentDto {
    private Long id;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private Long subscriberId;
}