package com.think_get_it.pojo.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductAddedToCartPojo {
    private String success;
    private String message;
    private Object data;
}
