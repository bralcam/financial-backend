package com.financial.incomingsource.validator;

import com.financial.incomingsource.model.IncomingSourceEntity;
import com.google.common.base.Strings;
import com.sun.media.sound.InvalidDataException;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Component
public class IncomingSourceSaveValidator implements IValidator<IncomingSourceEntity> {

    @Override
    public void validate(IncomingSourceEntity entity) throws InvalidDataException {
        StringBuilder sb = new StringBuilder();
        String breakLine = System.lineSeparator();
        if (nonNull(entity.getId()) && entity.getId().equals(0)) {
            sb.append("Incoming source id must be filled.").append(breakLine);
        }
        if (Strings.isNullOrEmpty(entity.getName())) {
            sb.append("Incoming source name must be filled.").append(breakLine);
        }
        if (Strings.isNullOrEmpty(entity.getDescription())) {
            sb.append("Incoming source description must be filled.").append(breakLine);
        }
        if (isNull(entity.getType())) {
            sb.append("Incoming source type must be filled.").append(breakLine);
        }
        if (sb.length() > 0) {
            throw new InvalidDataException(sb.toString());
        }
    }

}
