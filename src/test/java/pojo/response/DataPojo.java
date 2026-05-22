package pojo.response;

import lombok.Data;

@Data
public class DataPojo {
    private User user;

    private String token;

    private String refreshToken;
}
