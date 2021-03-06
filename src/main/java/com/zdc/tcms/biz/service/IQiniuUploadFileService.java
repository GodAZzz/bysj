package com.zdc.tcms.biz.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * 七牛上传文件服务
 */
public interface IQiniuUploadFileService {

    Response uploadFile(File file) throws QiniuException;

    Response uploadFile(InputStream inputStream, String key) throws QiniuException;

    Response delete(String key) throws QiniuException;

    public String getPictureUrl(MultipartFile file);

    public String updatePictureUrl(String url, String username);
}
