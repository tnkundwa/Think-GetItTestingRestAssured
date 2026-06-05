package com.think_get_it.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDataPojo {
    private User user;

    private String token;

    private String refreshToken;
}
