package cn.mall.shop.component;

import lombok.Data;

@Data
public class FileResult {

    private boolean uploadStatus;
    private String fileOriginName;
    private String fileType;
    private String baseDir;
    private String fileName;

    public FileResult() {

    }

    public FileResult(String fileOriginName, String fileType, String baseDir, String fileName) {
        this.setBaseDir(baseDir);
        this.setFileOriginName(fileOriginName);
        this.setFileType(fileType);
        this.setFileName(fileName);
    }

}
