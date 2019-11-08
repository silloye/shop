package cn.mall.shop.controller;

import cn.mall.shop.data.ProductDetailVO;
import cn.mall.shop.data.ProductUploadVO;
import cn.mall.shop.data.ResultVO;
import cn.mall.shop.mybatis.dao.ProductMapper;
import cn.mall.shop.mybatis.entity.Product;
import cn.mall.shop.mybatis.entity.ProductType;
import cn.mall.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 编辑用户上传的商品页面
 */
@RestController
@RequestMapping("/product")
public class ProductManageController extends BaseController {

    @Value("${file.upload.path}")
    private static String path;

    @Autowired
    private ProductService productService;

    @RequestMapping("/submit")
    public ResultVO submit(ProductUploadVO product) {
        boolean flag = this.productService.addProduct(product);
        return flag ? this.getSuccess() : this.getFailure();
    }

    @RequestMapping("/getProductType")
    public List<ProductType> getProductType() {
        return this.productService.listProductType();
    }

    @RequestMapping("/productDetail")
    public ProductDetailVO productDetail(String productId) {
        return this.productService.getProductDetail(productId);
    }

}
