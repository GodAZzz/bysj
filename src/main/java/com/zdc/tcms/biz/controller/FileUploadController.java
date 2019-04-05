package com.zdc.tcms.biz.controller;

import com.zdc.tcms.biz.service.IQiniuUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String result = null;
        HttpSession session = request.getSession();
        String loginUser = (String) session.getAttribute("loginUser");
        System.out.println(loginUser);
        if (loginUser == null || loginUser == "") {
            result = "empty";
        } else {
            String pictureUrl = iQiniuUploadFileService.getPictureUrl(file);
            System.out.println(pictureUrl);
            if(pictureUrl == "error"){
                result = "error";
            }else {
                result = iQiniuUploadFileService.updatePictureUrl(pictureUrl, loginUser);
            }
        }
        return result;
    }



}
