package com.think_get_it.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsPojo {
    private String id;

    private String cartId;

    private String productId;

    private Object variantId;

    private Integer quantity;

    private Boolean savedForLater;

    private String createdAt;

    private ProductsEndPointData product;

    private Object variant;
}
