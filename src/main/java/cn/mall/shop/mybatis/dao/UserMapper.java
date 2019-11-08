package cn.mall.shop.mybatis.dao;

import cn.mall.shop.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getById(int id);

    List<User> getUserByName(String name);

}
