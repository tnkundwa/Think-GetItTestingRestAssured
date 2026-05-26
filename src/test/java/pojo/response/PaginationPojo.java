package pojo.response;

import lombok.Data;

@Data
public class PaginationPojo {
    private Integer page;

    private Integer limit;

    private Integer total;

    private Integer pages;
}
