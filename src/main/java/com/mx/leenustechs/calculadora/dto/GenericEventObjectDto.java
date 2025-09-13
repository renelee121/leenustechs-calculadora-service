package com.mx.leenustechs.calculadora.dto;

import java.util.UUID;


import com.fasterxml.jackson.databind.JsonNode;
import com.mx.leenustechs.calculadora.model.GenericEventObject;
import com.mx.leenustechs.calculadora.model.request.GenericEventObjectRequest;
import com.mx.leenustechs.calculadora.model.response.GenericEventObjectResponse;
import com.mx.leenustechs.calculadora.model.types.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericEventObjectDto {
    private UUID transactionId;
    private OperationType operationType;
    private JsonNode payload;

    public GenericEventObjectDto(GenericEventObject event){
        this.transactionId = event.getTransactionId();
        this.operationType = event.getOperationType();
        this.payload = event.getPayload();
    }

    public GenericEventObject toModel(){
        return new GenericEventObject(
            this.transactionId,
            this.operationType,
            this.payload
        );
    }

    public GenericEventObjectDto(GenericEventObjectRequest event){
        this.transactionId = UUID.randomUUID();
        this.operationType = event.getOperationType();
        this.payload = event.getPayload();
    }

    public GenericEventObjectRequest toRequest(){
        return new GenericEventObjectRequest(
            this.operationType,
            this.payload
        );
    }

    public GenericEventObjectDto(GenericEventObjectResponse event){
        this.transactionId = event.getTransactionId();
        this.operationType = event.getOperationType();
        this.payload = event.getPayload();
    }

    public GenericEventObjectResponse toResponse(){
        return new GenericEventObjectResponse(
            this.transactionId,
            this.operationType,
            this.payload
        );
    }

}
