package cn.mall.shop.mybatis.dao;

import cn.mall.shop.mybatis.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> getHotProduct();

    boolean insert(Product product);

}
