package com.kcwebapply.api.springapi.exception;

public abstract  class AbstractException  extends RuntimeException{

    String level;

    public AbstractException(String message, String level){
        super(message);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level){
        this.level = level;
    }
}
