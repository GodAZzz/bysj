package com.zdc.core.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 阿里云短信服务
 */
@Slf4j
public class AliyunSmsUtils {

    //产品名称:云通信短信API产品,开发者无需替换
    private static final String PRODUCT = "Dysmsapi";

    //产品域名,开发者无需替换
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";

    //此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    private static final String ACCESS_KEY_ID = "LTAIhvvR9UlmL75l";
    private static final String ACCESS_KEY_SECRET = "XhrVorTlMKD6wFSl8LXUTjpgut2huc";

    //短信签名
    private static final String SIGN_NAME = "中医食疗";

    //短信模板
    private static final String TEMPLATE_CODE = "SMS_161895939";

    /**
     *生成六位数验证码
     * @return
     */
    public static String getMessageCode(){
        return String.valueOf(new Random().nextInt(899999) + 100000);
    }

    /**
     *发送短信验证码
     * @param phone
     * @param code
     */
    public static SendSmsResponse sendSms(String phone, String code) throws ClientException{
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();

        //必填:待发送手机号
        request.setPhoneNumbers(phone);

        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SIGN_NAME);

        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(TEMPLATE_CODE);

        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\""+code+"\"}");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        return acsClient.getAcsResponse(request);
    }

    /**
     * 查询发送的短信验证码信息
     */
    public static QuerySendDetailsResponse querySendDetails(String bizId, String phone) throws ClientException{
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();

        //必填-号码
        request.setPhoneNumber(phone);

        //可选-流水号
        request.setBizId(bizId);

        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));

        //必填-页大小
        request.setPageSize(10L);

        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        //hint 此处可能会抛出异常，注意catch
        return acsClient.getAcsResponse(request);
    }
}
