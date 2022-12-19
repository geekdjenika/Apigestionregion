package com.malitourist.Apigestionregion.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Existedeja extends RuntimeException{
    private String message;
}
