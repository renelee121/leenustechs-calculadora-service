package com.mx.leenustechs.calculadora.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mx.leenustechs.calculadora.model.GenericEventObject;

import java.nio.charset.StandardCharsets;

@Service
public class ProducerService {
    @Value("${kafka.response.topic.name}")
    private String topic;

    @Value("${spring.application.name}") 
    private String serviceName;
    
    private final KafkaTemplate<String, GenericEventObject> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, GenericEventObject> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String key, GenericEventObject message) {
        ProducerRecord<String, GenericEventObject> record = new ProducerRecord<>(topic, key, message);
        record.headers().add(new RecordHeader("X-ORIGIN", serviceName.getBytes(StandardCharsets.UTF_8)));

        kafkaTemplate.send(record);
    }
}
