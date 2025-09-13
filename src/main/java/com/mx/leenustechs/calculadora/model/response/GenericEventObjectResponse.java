package com.mx.leenustechs.calculadora.model.response;

import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import com.mx.leenustechs.calculadora.model.types.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericEventObjectResponse{
    private UUID transactionId;
    private OperationType operationType;
    private JsonNode payload;
}
