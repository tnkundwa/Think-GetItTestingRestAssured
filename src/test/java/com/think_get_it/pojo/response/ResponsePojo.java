package com.think_get_it.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsePojo<T> {
    private Boolean success;

    private String message;

    private T data;

    private PaginationPojo pagination;
}


