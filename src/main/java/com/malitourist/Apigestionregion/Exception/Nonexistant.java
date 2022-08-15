package com.malitourist.Apigestionregion.Exception;

public class Nonexistant extends RuntimeException{
    private String message;
    public Nonexistant() {}
    public Nonexistant(String msg) {
        super(msg);
        this.message = msg;
    }
}
