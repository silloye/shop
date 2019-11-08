package cn.mall.shop;

import cn.mall.shop.data.HomePageVo;
import cn.mall.shop.mybatis.dao.UserMapper;
import cn.mall.shop.mybatis.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
/**
 * 指定包下所有实现类为接口，该包下不用再写@Mapper
 */
@MapperScan("cn.mail.shop.mybatis.dao")
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
    public List test() {
        HomePageVo vo = new HomePageVo();
        for(int i=0; i<10; i++) {
            HomePageVo.Product p = vo.new Product();
            p.setTitle("火锅，低价 48.9,\\r\\n 肥牛一碟，鸡肉一碟，蔬菜一盘");
//            p.setImgUrl("https://img.51miz.com/preview/element/00/01/09/56/E-1095659-C0391861.jpg!/quality/90/unsharp/true/compress/true/fw/840");
            p.setImgUrl("../../static/1.jpg");
            vo.getList().add(p);
        }
        return vo.getList();
    }


}
