package cn.mall.shop.data;

import cn.mall.shop.mybatis.entity.Product;
import io.netty.util.internal.StringUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class ProductDetailVO {

    private Product product;
    private static String baseUrl;
    private List<String> imgUrls = new ArrayList<>();

    @Value("${file.baseUrl}")
    public void setBaseUrl(String baseUrl) {
        ProductDetailVO.baseUrl = baseUrl;
    }

    public List<String> getImgUrls() {
        if(StringUtil.isNullOrEmpty(product.getFileNames())) {
            return null;
        }
        String[] fileNames = product.getFileNames().split(",");
        for(String fileName : fileNames) {
            imgUrls.add(baseUrl + fileName);
        }
        return imgUrls;
    }

}
