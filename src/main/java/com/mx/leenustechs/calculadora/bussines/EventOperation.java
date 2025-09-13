package com.mx.leenustechs.calculadora.bussines;

import org.springframework.stereotype.Service;

import com.mx.leenustechs.calculadora.model.GenericEventObject;
import com.mx.leenustechs.calculadora.model.response.GenericEventObjectResponse;


@Service
public interface EventOperation {
    GenericEventObjectResponse execute(GenericEventObject event);
}
