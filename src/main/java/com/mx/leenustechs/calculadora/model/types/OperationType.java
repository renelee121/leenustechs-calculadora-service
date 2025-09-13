package com.mx.leenustechs.calculadora.model.types;

import com.mx.leenustechs.calculadora.bussines.EventOperation;
import com.mx.leenustechs.calculadora.model.GenericEventObject;
import com.mx.leenustechs.calculadora.model.response.GenericEventObjectResponse;
import com.mx.leenustechs.calculadora.service.OperationTypeService;

public enum OperationType {
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION,
    RAIZ,
    EXPONENTE,
    FACTORIAL;

    public GenericEventObjectResponse execute(GenericEventObject GenericEventObject, OperationTypeService operationTypeService){
        EventOperation operation = operationTypeService.getOperation(this);
        return operation.execute(GenericEventObject);
    }
}
