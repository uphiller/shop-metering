package com.shop.metering.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.metering.entity.ApiCallHistroy;
import com.shop.metering.entity.repository.ApiCallHistroyRepository;
import com.shop.metering.service.dto.ApiCall;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class KafkaConsumerService {

    private final ApiCallHistroyRepository apiCallHistroyRepository;

    @KafkaListener(topics = "callApi")
    public void consume(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ApiCall apiCall = objectMapper.readValue(message, ApiCall.class);

        ApiCallHistroy apiCallHistroy = ApiCallHistroy.builder()
                .url(apiCall.getUrl())
                .userId(apiCall.getUserId())
                .build();

        apiCallHistroyRepository.save(apiCallHistroy);

    }
}