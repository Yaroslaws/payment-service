package com.example.payment_service.repository;

import com.example.payment_service.entity.Payment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PaymentRepository extends ReactiveCrudRepository<Payment, Long> {

    Flux<Payment> findAllBySubscriberId(Long subscriberId);



}
