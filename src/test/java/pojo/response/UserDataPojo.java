package pojo.response;

import lombok.Data;

@Data
public class UserDataPojo {
    private User user;

    private String token;

    private String refreshToken;
}
