package cn.mall.shop.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
@PropertySource({"classpath:application-dev.yaml"})
public class FileUtils {

    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    protected static String PATH;

    @Value("${file.upload.path}")
    public void setPath(String path) {
        PATH = path;
    }

    public static FileResult upload(MultipartFile file, String path, String fileName) {
        logger.info("===== start upload file : " + logger + " =====");
        path = path == null? FileUtils.PATH : path;
        String realPath = path + fileName;
        File dest = new File(realPath);
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        FileResult result = new FileResult(file.getOriginalFilename(),file.getContentType(), path, fileName);
        try {
            file.transferTo(dest);
            logger.info("===== upload file : " + logger + " success! =====");
            result.setUploadStatus(true);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("===== upload file : " + logger + " faile : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("===== upload file : " + logger + " faile : " + e.getMessage());
        }
        result.setUploadStatus(false);
        return result;
    }

    public static String getSuffix(String fileName) {
        String[] strArray = fileName.split("\\.");
        int suffixIndex = strArray.length -1;
        return strArray[suffixIndex];
    }

}
