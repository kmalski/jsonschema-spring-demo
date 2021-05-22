package com.zti.jsonschema.demo.validation;

import com.networknt.schema.ValidationMessage;

import java.util.Set;

public class JsonValidationException extends RuntimeException {
    private final Set<ValidationMessage> validationMessages;

    public JsonValidationException(Set<ValidationMessage> validationMessages) {
        this.validationMessages = validationMessages;
    }

    public Set<ValidationMessage> getValidationMessages() {
        return validationMessages;
    }
}
