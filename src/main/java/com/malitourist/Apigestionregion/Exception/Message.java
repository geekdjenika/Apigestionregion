package com.malitourist.Apigestionregion.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Message {
    public static ResponseEntity<Object> ErreurReponse(String msg,HttpStatus status) {
        Map<String,Object> map;
        map = new HashMap<>();
        map.put("Message", msg);
        return new ResponseEntity<>(map, status);
    }
}
