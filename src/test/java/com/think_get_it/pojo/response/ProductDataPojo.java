package com.think_get_it.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDataPojo {

    private String id;

    private String name;

    private String slug;

    private String description;

    private Object image;

    private Object parentId;

    private String createdAt;

    private String updatedAt;

    private List<Object> children;

    @JsonProperty("_count")
    private Count count;

}
