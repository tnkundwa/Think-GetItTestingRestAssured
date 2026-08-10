package com.think_get_it.pojo.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class RegisterUser {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}