package com.example.payment_service.dto.mapper;


import com.example.payment_service.dto.SubscriberDto;
import com.example.payment_service.entity.Subscriber;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SubscriberMapper {


    SubscriberDto toDto(Subscriber subscriber);

    Subscriber toEntity(SubscriberDto subscriberDto);
}