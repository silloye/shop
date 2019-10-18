package cn.mall.shop.dao;

import cn.mall.shop.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getById(int id);

}
