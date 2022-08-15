package com.malitourist.Apigestionregion.Exception;

public class Existedeja extends RuntimeException{
    private String message;
    public Existedeja() {}
    public Existedeja(String msg) {
        super(msg);
        this.message = msg;
    }
}
