package cn.mall.shop.service;

import cn.mall.shop.component.FileResult;
import cn.mall.shop.component.FileUtils;
import cn.mall.shop.data.HomePageVo;
import cn.mall.shop.data.ProductDetailVO;
import cn.mall.shop.data.ProductUploadVO;
import cn.mall.shop.mybatis.dao.ProductMapper;
import cn.mall.shop.mybatis.dao.ProductTypeMapper;
import cn.mall.shop.mybatis.entity.Product;
import cn.mall.shop.mybatis.entity.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductTypeMapper productTypeMapper;

    public List<ProductType> listProductType() {
        return this.productTypeMapper.getProductType();
    }

    public List<HomePageVo.Product> listHotProduct() {
        List<Product> productList = productMapper.getHotProduct();
        HomePageVo vo = new HomePageVo();
        for(Product p :  productList) {
            vo.getList().add(HomePageVo.buildProduct(p));
        }
        return vo.getList();
    }

    public boolean addProduct(ProductUploadVO product) {
        MultipartFile[] files = product.getFiles();
        List<FileResult> results = new ArrayList<>();
        String fileNames = "";
        for(MultipartFile file : files) {
            FileResult result = FileUtils.upload(file, null, UUID.randomUUID().toString() + "." + FileUtils.getSuffix(file.getOriginalFilename()));
            if(!result.isUploadStatus()) {
                return false;
            }
            fileNames += result.getFileName() + ",";
            results.add(result);
        }
        Product p = new Product();
        p.setBaseDir(results.size()==0? "" : results.get(0).getBaseDir());
        p.setDescribe(product.getDescribe());
        p.setFileNames(fileNames);
        p.setName(product.getName());
        p.setOriginName(product.getOriginNames());
        p.setType(product.getType());
        p.setPrice(product.getPrice());
        p.setMeasure(product.getMeasure());
        return productMapper.insert(p);
    }

    public ProductDetailVO getProductDetail(String productId) {
        ProductDetailVO vo = new ProductDetailVO();
        Product product = this.productMapper.getById(productId);
        vo.setProduct(product);
        return vo;
    }

}
