package com.mx.leenustechs.calculadora.bussines.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.leenustechs.calculadora.model.GenericEventObject;

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class GenericEventObjectSerializer implements Serializer<GenericEventObject> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Configuración si se necesita
    }

    @Override
    public byte[] serialize(String topic, GenericEventObject data) {
        try {
            if (data == null) {
                return null;
            }
            return objectMapper.writeValueAsBytes(data); // Convierte el DTO a JSON bytes
        } catch (Exception e) {
            throw new RuntimeException("Error serializing GenericEventObjectDto", e);
        }
    }

    @Override
    public void close() {
        // Cierre si es necesario
    }
}
