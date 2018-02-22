package org.dougllas.mymoney.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Criado por dougllas.sousa em 22/02/2018.
 */
public class Response<T> {

    private T data;
    private List<String> errors;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        if(errors == null){
            errors = new ArrayList<>();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public static <T> Response<T> createResponse(T data){
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }
}
