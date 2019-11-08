package cn.mall.shop.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Integer id;
    private String name;
    private String baseDir;
    private String fileNames;
    private String describe;
    private int type;
    private String originName;
    private String fileType;
    private float price;
    private String measure;

}
