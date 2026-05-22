package pojo.response;

import lombok.Data;

@Data
public class UserResponse {
    private Boolean success;

    private String message;

    private DataPojo data;
}


