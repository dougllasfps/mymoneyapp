package org.dougllas.mymoney.exceptionhandler;

import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Criado por dougllas.sousa em 11/01/2018.
 */
public interface ValidationHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    default JSONArray validationError(MethodArgumentNotValidException ex) {
        return createJsonArrayFromErrors(ex);
    }

    default JSONArray createJsonArrayFromErrors(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        return new ValidationResponseErrors(result).getErrorMessages();
    }
}
