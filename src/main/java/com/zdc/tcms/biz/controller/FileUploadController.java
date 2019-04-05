package com.zdc.tcms.biz.controller;

import com.qiniu.http.Response;
import com.zdc.tcms.biz.service.IQiniuUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件上传
 */
@RestController
public class FileUploadController {

    @Autowired
    private IQiniuUploadFileService iQiniuUploadFileService;
    /**
     * 上传文件
     */
    @RequestMapping(value = "/upload")
    public String upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        //自定义的文件名称
        String trueFileName = String.valueOf(System.currentTimeMillis())+fileName;
        System.out.println(trueFileName);
        InputStream inputStream = file.getInputStream();
        Response response = iQiniuUploadFileService.uploadFile(inputStream, trueFileName);
        if(response != null){
            //测试域名
            String csdn = "http://ppfqedo90.bkt.clouddn.com/";
            String address = csdn + trueFileName;
            return address;
        }else {
            String address = "error";
            return address;
        }
    }
}
