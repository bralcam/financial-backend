package com.financial.incomingsource.validator;

import com.sun.media.sound.InvalidDataException;

public interface IValidator<T> {
    void validate(T entity) throws InvalidDataException;
}
