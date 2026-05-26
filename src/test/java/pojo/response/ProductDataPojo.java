package pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
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
