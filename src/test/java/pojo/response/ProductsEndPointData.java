package pojo.response;

import lombok.Data;

import java.util.List;

@Data
public class ProductsEndPointData {

    private String id;

    private String name;

    private String slug;

    private String description;

    private Double price;

    private Double comparePrice;

    private String categoryId;

    private List<String> tags;

    private Boolean isActive;

    private Boolean isFeatured;

    private Boolean isFlashSale;

    private Object flashSalePrice;

    private Object flashSaleEnds;

    private Double rating;

    private Integer reviewCount;

    private Integer soldCount;

    private Integer viewCount;

    private String createdAt;

    private String updatedAt;

    private Object searchVector;

    private List<ImagesPojo> images;

    private CategoryPojo category;

    private InventoryPojo inventory;

    private List<Object> variants;

}
