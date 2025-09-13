package com.mx.leenustechs.calculadora.model.request;

import com.fasterxml.jackson.databind.JsonNode;
import com.mx.leenustechs.calculadora.model.types.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericEventObjectRequest{
    private OperationType operationType;
    public JsonNode payload;
}
