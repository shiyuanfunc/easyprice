package com.third.easyprice.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.zip.GZIPInputStream;

public class ShopTest {

    String scanUrl=URLEncoder.encode("https://item.taobao.com/item.htm?id=527032470420","UTF-8");

    String appid="52b72013dbbbc808b7c8f07d1cbf4d9e" ;

    String httpUrl = "https://api.shenjian.io/";

    String httpArg = "appid="+appid+"&scanUrl="+scanUrl;

    String jsonResult = request(httpUrl, httpArg);

    public ShopTest() throws UnsupportedEncodingException {
    }

    //System.out.println(jsonResult);

    /**

     * @param

     * :请求接口

     * @param httpArg

     * :参数

     * @return 返回结果

     */

    public static String request(String httpUrl, String httpArg) {

        BufferedReader reader = null;

        String result = null;

        StringBuffer sbf = new StringBuffer();

        httpUrl = httpUrl + "?" + httpArg;

        try {

            URL url = new URL(httpUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            connection.setRequestProperty("charset", "utf-8");

            connection.setRequestProperty("Accept-Encoding", "gzip");

            connection.connect();

            InputStream is = new GZIPInputStream(connection.getInputStream());

            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String strRead = null;

            while ((strRead = reader.readLine()) != null) {

                sbf.append(strRead);

                sbf.append("\r\n");

            }

            reader.close();

            result = sbf.toString();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return result;

    }
}
