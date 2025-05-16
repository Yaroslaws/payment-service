package com.example.payment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberPaymentsDto {

    private SubscriberDto subscriberDto;
    private List<PaymentDto> paymentDto;
}
