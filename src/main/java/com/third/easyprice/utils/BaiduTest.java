package com.third.easyprice.utils;


import com.baidu.aip.util.Base64Util;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.net.URLEncoder;

public class BaiduTest {

    String AppID = "11669071";
    String APIKey = "1prsmicsc5I5mYUNCMsmhXru";
    private String SecretKey = "qjB0xoEgkA6SukMclFwkezo9UEpfVzqe";

    private String accessToken = "24.e32414dd59bccc36b37231fceeb084e4.2592000.1536738412.282335-11669071";


    public String detect() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/advanced_general";
        //String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/object_detect";
        try {
            // 本地文件路径
            String filePath = "[本地文件路径]";
            byte[] imgData = FileUtils.readFileToByteArray(new File("C:\\Users\\song\\Desktop\\computer.jpg"));
           // byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam + "&with_face=" + 1;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            //String accessToken = accessKey;

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println("------------"+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {

        new BaiduTest().detect();
    }
}
