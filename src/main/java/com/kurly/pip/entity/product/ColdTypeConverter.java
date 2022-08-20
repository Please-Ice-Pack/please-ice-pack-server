package com.kurly.pip.entity.product;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColdTypeConverter implements AttributeConverter<ColdType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ColdType coldType) {

        return coldType.getCode();
    }

    @Override
    public ColdType convertToEntityAttribute(Integer code) {

        return ColdType.ofCode(code);
    }
}
