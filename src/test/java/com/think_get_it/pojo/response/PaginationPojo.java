package com.think_get_it.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaginationPojo {
    private Integer page;

    private Integer limit;

    private Integer total;

    private Integer pages;
}
