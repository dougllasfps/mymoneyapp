package org.dougllas.mymoney.exceptionhandler;

import org.json.JSONArray;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Criado por dougllas.sousa em 11/01/2018.
 */
public class ValidationResponseErrors {

    private Errors errors;

    public ValidationResponseErrors(Errors errors) {
        this.errors = errors;
    }

    public JSONArray getErrorMessages(){
        List<ObjectError> allErrors = errors.getAllErrors();
        List<String> errorMessages = allErrors.stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
        JSONArray objects = new JSONArray(errorMessages);
        return objects;
    }
}