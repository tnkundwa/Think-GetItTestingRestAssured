package com.think_get_it.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDataPojo {
    private String id;

    private String userId;

    private String label;

    private String firstName;

    private String lastName;

    private String phone;

    private String street;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    private Boolean isDefault;

    private String createdAt;
}
