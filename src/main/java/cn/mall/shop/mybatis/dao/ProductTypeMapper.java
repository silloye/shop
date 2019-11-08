package cn.mall.shop.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import cn.mall.shop.mybatis.entity.ProductType;

import java.util.List;

@Mapper
public interface ProductTypeMapper extends BaseMapper<ProductType> {

    List<ProductType> getProductType();

}
