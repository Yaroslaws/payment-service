package com.example.payment_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Table(name = "payment")
@NoArgsConstructor
public class Payment {

    @Id
    private Long id;

    private BigDecimal amount;

    private LocalDateTime paymentDate;

    @Column("subscriber_id")
    private Long subscriberId;

}