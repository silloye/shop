package cn.mall.shop.mybatis.dao;

import java.io.Serializable;

public interface BaseMapper<T> {

    T getById(Serializable id);

}
