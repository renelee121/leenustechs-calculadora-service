package com.mx.leenustechs.calculadora.service;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mx.leenustechs.calculadora.bussines.EventOperation;
import com.mx.leenustechs.calculadora.bussines.useCase.*;
import com.mx.leenustechs.calculadora.model.types.OperationType;

@Service
public class OperationTypeService {

    private Map<OperationType, EventOperation> operationMap = new EnumMap<>(OperationType.class);

    public OperationTypeService(SumaUseCase suma,RestaUseCase resta,MultiplicacionUseCase multiplicacion,
            DivisionUseCase division, FactorialUseCase factorial, ExponencialUseCase exponencial,
            RaizUseCase raiz) {
        operationMap.put(OperationType.SUMA, suma);
        operationMap.put(OperationType.RESTA, resta);
        operationMap.put(OperationType.MULTIPLICACION, multiplicacion);
        operationMap.put(OperationType.DIVISION, division);
        operationMap.put(OperationType.EXPONENTE, exponencial);
        operationMap.put(OperationType.FACTORIAL, factorial);
        operationMap.put(OperationType.RAIZ, raiz);
    }

    public EventOperation getOperation(OperationType operationType){
        return operationMap.get(operationType);
    }
}
