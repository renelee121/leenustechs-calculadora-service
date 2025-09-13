package com.mx.leenustechs.calculadora.bussines.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.leenustechs.calculadora.model.GenericEventObject;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class GenericEventObjectDeserializer implements Deserializer<GenericEventObject> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // no-op
    }

    @Override
    public GenericEventObject deserialize(String topic, byte[] data) {
        try {
            if (data == null) return null;
            return objectMapper.readValue(data, GenericEventObject.class);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing GenericEventObject", e);
        }
    }

    @Override
    public void close() {
        // no-op
    }
}
