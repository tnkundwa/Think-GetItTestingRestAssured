package com.think_get_it.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesPojo {

    private String id;

    private String productId;

    private String url;

    private String publicId;

    private String alt;

    private Integer order;

}
