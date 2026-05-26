package pojo.response;

import lombok.Data;

@Data
public class ResponsePojo<T> {
    private Boolean success;

    private String message;

    private T data;

    private PaginationPojo pagination;
}


