package com.example.payment_service.repository;

import com.example.payment_service.entity.Payment;
import com.example.payment_service.entity.Subscriber;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends ReactiveCrudRepository<Subscriber, Long> {


}
