package com.captians.slangdictionary.dto;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class UserMessage {
    private String message;
    private List<String> fieldErrors = new ArrayList<>();
    private HttpStatus httpStatus;

    public UserMessage(StringBuffer requestURL, Exception ex) {
        message = ex.getMessage();
    }

    public UserMessage(String message) {
        this.message = message;
    }

    public UserMessage() {
    }

    public void setErrors(List<FieldError> errors) {
        for (FieldError fieldError: errors) {
            fieldErrors.add(fieldError.getField() + " : " +fieldError.getDefaultMessage());
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrorsAsString() {
        return fieldErrors;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
