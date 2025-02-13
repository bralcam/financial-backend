package com.financial.incomingsource.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.financial.incomingsource.model.IncomingSourceEntity;
import com.financial.incomingsource.vo.IncomingSourceVO;
import org.springframework.stereotype.Component;

@Component
public class IncomingSourceConverter implements Converter<IncomingSourceEntity, IncomingSourceVO> {

    @Override
    public IncomingSourceVO convert(IncomingSourceEntity incomingSourceEntity) {
        IncomingSourceVO incomingSourceVO = new IncomingSourceVO();
        incomingSourceVO.setId(incomingSourceEntity.getId());
        incomingSourceVO.setName(incomingSourceEntity.getName());
        incomingSourceVO.setDescription(incomingSourceVO.getDescription());
        incomingSourceVO.setType(incomingSourceEntity.getType());
        return incomingSourceVO;
    }

    public IncomingSourceEntity generate(IncomingSourceVO incomingSourceVO) {
        IncomingSourceEntity incomingSourceEntity = new IncomingSourceEntity();
        incomingSourceEntity.setId(incomingSourceVO.getId());
        incomingSourceEntity.setName(incomingSourceVO.getName());
        incomingSourceEntity.setDescription(incomingSourceVO.getDescription());
        incomingSourceEntity.setType(incomingSourceVO.getType());
        return incomingSourceEntity;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }

}
