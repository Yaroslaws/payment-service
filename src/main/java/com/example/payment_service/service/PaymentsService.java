package com.example.payment_service.service;

import com.example.payment_service.dto.PaymentDto;
import com.example.payment_service.dto.SubscriberDto;
import com.example.payment_service.dto.SubscriberPaymentsDto;
import com.example.payment_service.dto.mapper.PaymentMapper;
import com.example.payment_service.dto.mapper.SubscriberMapper;
import com.example.payment_service.kafka.KafkaProducerService;
import com.example.payment_service.repository.PaymentRepository;
import com.example.payment_service.repository.SubscriberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
@RequiredArgsConstructor
public class PaymentsService {

    private final PaymentRepository paymentRepository;
    private final SubscriberRepository subscriberRepository;
    private final PaymentMapper paymentMapper;
    private final SubscriberMapper subscriberMapper;
    private final KafkaProducerService kafkaProducerService;

    public Flux<SubscriberPaymentsDto> getPayments() {
        return subscriberRepository.findAll()
                .flatMap(subscriber -> {
                    SubscriberDto subscriberDto = subscriberMapper.toDto(subscriber);
                    return paymentRepository.findAllBySubscriberId(subscriber.getId())
                            .switchIfEmpty(Flux.empty()) // Явно указываем пустой Flux
                            .map(paymentMapper::toDto)
                            .collectList()
                            .map(payments -> new SubscriberPaymentsDto(subscriberDto, payments));
                });
    }


    public void createPayment(PaymentDto paymentDto) {
        kafkaProducerService.send(paymentDto.toString());
        paymentRepository.save(paymentMapper.toEntity(paymentDto));
    }
}
