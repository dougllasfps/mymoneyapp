package org.dougllas.mymoney.generic;

import org.dougllas.mymoney.api.Response;
import org.springframework.validation.BindingResult;

/**
 * Criado por dougllas.sousa em 28/02/2018.
 */
public interface ErrorHandler {

    default boolean handleErrors(BindingResult result, Response response) {
        if(result.hasErrors()){
            result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
            return true;
        }
        return false;
    }
}
