package com.think_get_it.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartDataPojo {
    private String id;

    private Object userId;

    private String sessionId;

    private Object couponCode;

    private String createdAt;

    private String updatedAt;

    private List<ItemsPojo> items;

    private Integer subtotal;

    private Integer discount;

    private Integer total;

    private Integer itemCount;

    private Object coupon;
}
