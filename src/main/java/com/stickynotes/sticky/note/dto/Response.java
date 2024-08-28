package com.stickynotes.sticky.note.dto;

public class Response {

    private String message;

    private Object body = null;

    private boolean status = false;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return body;
    }

    public void setObject(Object object) {
        this.body = object;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Response() {
     }

    public Response(String message, Object object, boolean status) {
        this.message = message;
        this.body = object;
        this.status = status;
    }
}
