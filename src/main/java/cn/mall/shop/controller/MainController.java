package cn.mall.shop.controller;

import cn.mall.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController extends BaseController {

    @Autowired
    private ProductService productService;

    @RequestMapping("hotProducts")
    public List<?> hotProducts() {
        return this.productService.listHotProduct();
    }

}
