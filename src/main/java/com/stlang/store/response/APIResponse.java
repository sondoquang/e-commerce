package com.stlang.store.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIResponse {

    private String message;
    private Object data;

    public APIResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}
