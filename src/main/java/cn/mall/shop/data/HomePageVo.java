package cn.mall.shop.data;

import cn.mall.shop.mybatis.entity.Product;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class HomePageVo {

    private List<Product> list;

    private static String baseUrl;
    @Value("${file.baseUrl}")
    public void getBaseUrl(String baseUrl) {
        HomePageVo.baseUrl = baseUrl;
    }

    public HomePageVo() {
        list = new ArrayList<>();
    }

    @Data
    public class Product {
        private String title;
        private String imgUrl;
        private int productId;
    }

    public static Product buildProduct(cn.mall.shop.mybatis.entity.Product product) {
        Product p = new HomePageVo().new Product();
        p.title = product.getDescribe();
        String fileName = product.getFileNames().split(",")[0];
        p.imgUrl = HomePageVo.baseUrl + fileName;
        p.productId = product.getId();
        return p;
    }

}
