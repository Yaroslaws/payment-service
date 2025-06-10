package com.example.payment_service.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@Table(name = "subscriber")
@NoArgsConstructor
public class Subscriber {

    @Id
    private Long id;

    private String email;

    private String name;

}
