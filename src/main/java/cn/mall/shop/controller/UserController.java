package cn.mall.shop.controller;

import cn.mall.shop.mybatis.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

}
