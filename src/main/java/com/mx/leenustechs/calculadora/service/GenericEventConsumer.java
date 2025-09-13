package com.mx.leenustechs.calculadora.service;

import com.mx.leenustechs.calculadora.model.GenericEventObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GenericEventConsumer {

    @Autowired
    private OperationTypeService operationTypeService;

    @KafkaListener(topics = "${kafka.request.topic.name}", groupId = "leenustechs-calculadora-service-group")
    public void consume(GenericEventObject event) {
        event.getOperationType().execute(event, operationTypeService);
    }
}
