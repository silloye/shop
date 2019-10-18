package cn.mall.shop;

import cn.mall.shop.dao.UserMapper;
import cn.mall.shop.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootApplication
/**
 * 指定包下所有实现类为接口，该包下不用再写@Mapper
 */
@MapperScan("cn.mail.shop.dao")
//@RunWith(SpringJUnit4ClassRunner.class)
@Controller
public class ShopApplication {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @RequestMapping("/test")
    @ResponseBody
    public void test() {
        User user = userMapper.getById(1);
        System.out.println("111");
    }


}
