package com.think_get_it.pojo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CouponsPojo {

    private String code;

    private String description;

    private String discountType;

    private Integer discountValue;

    private Integer minOrderAmount;

    private Integer maxUsers;

    private String expiresAt;

}
