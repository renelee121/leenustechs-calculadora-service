package com.mx.leenustechs.calculadora.bussines.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mx.leenustechs.calculadora.bussines.EventOperation;
import com.mx.leenustechs.calculadora.dto.GenericEventObjectDto;
import com.mx.leenustechs.calculadora.model.GenericEventObject;
import com.mx.leenustechs.calculadora.model.response.GenericEventObjectResponse;
import com.mx.leenustechs.calculadora.service.ProducerService;

@Component
public class FactorialUseCase implements EventOperation{

    @Autowired
    public ProducerService producerService;

    @Override
    public GenericEventObjectResponse execute(GenericEventObject event) {
        GenericEventObjectDto dto = new GenericEventObjectDto(event);
        ObjectNode payload = (ObjectNode) dto.getPayload();
        Number a = payload.get("a").asDouble();
        long result = 1;
        for (long i = 2; i <= a.longValue(); i++) {
            result *= i;
        }
        payload.putPOJO("response", result);
        producerService.sendMessage(dto.getTransactionId().toString(), dto.toModel());
        return  dto.toResponse();
    }

}
