package com.zdc.tcms.biz.service.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.zdc.tcms.biz.mapper.UserMapper;
import com.zdc.tcms.biz.service.IQiniuUploadFileService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class QiniuUploadFileServiceImpl implements IQiniuUploadFileService, InitializingBean{

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Auth auth;

    @Value("${qiniu.Bucket}")
    private String bucket;

    @Autowired
    private UserMapper userMapper;



    /**
     *定义七牛云上传的相关策略
     */
    private StringMap putPolicy;

    /**
     *以文件的形式上传
     */
    @Override
    public Response uploadFile(File file) throws QiniuException {
        Response response = this.uploadManager.put(file, null, getUploadToken());
        int retry = 0;
        while(response.needRetry() && retry < 3){
            response = this.uploadManager.put(file, null, getUploadToken());
            retry++;
        }
        return response;
    }

    /**
     *以流的形式上传
     */
    @Override
    public Response uploadFile(InputStream inputStream, String key) throws QiniuException {
        Response response = this.uploadManager.put(inputStream, key , getUploadToken(), null, null);
        int retry = 0;
        while (response.needRetry() && retry < 3){
            response = this.uploadManager.put(inputStream, key, getUploadToken(), null, null);
            retry++;
        }
        return response;
    }

    /**
     * 删除七牛云上的相关文件
     */
    @Override
    public Response delete(String key) throws QiniuException {
        Response response = bucketManager.delete(this.bucket, key);
        int retry = 0;
        while (response.needRetry() && retry++ < 3){
            response = bucketManager.delete(bucket, key);
        }
        return response;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "http://ppfqedo90.bkt.clouddn.com/"+"$(key)");
    }

    /**
     * 获取上传凭证
     */
    private String getUploadToken(){
        return this.auth.uploadToken(bucket, null, 3600, putPolicy);
    }

    /**
     * 得到图片url
     */
    @Override
    public String getPictureUrl(MultipartFile file){
        String result = null;
        String fileName = file.getOriginalFilename();
        //自定义的文件名称
        String trueFileName = String.valueOf(System.currentTimeMillis())+fileName;
        try {
            InputStream inputStream = file.getInputStream();
            Response response = uploadFile(inputStream, trueFileName);
            if(response != null){
                //测试域名
                String csdn = "http://ppfqedo90.bkt.clouddn.com/";
                result = csdn + trueFileName;
            }else {
                result = "error";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updatePictureUrl(String url, String username) {
        int i = userMapper.updatePictureUrl(url, username);
        if(i > 0){
            return "success";
        }else {
            return "error";
        }
    }



}
