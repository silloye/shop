package cn.mall.shop.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductUploadVO {

    private String name;
    private MultipartFile[] files;
    private String describe;
    private int type;
    private float price;
    private String measure;

    public String getOriginNames() {
        String result = "";
        for(MultipartFile file: files) {
            result += file.getOriginalFilename() + ",";
        }
        return result.substring(0, result.length()-1);
    }
}
