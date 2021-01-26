package com.example.jm.jmm.util.jsoup;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class HttpClientUtil {

    /**
     * @Title: sendJsonStr
     * @Description: post发送json字符串
     * @param url
     * @param params
     * @return 返回数据
     * @author Mundo
     */
    public static String sendJsonStr(String url, String params) {
        String result = "";

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.addHeader("Content-type", "application/json; charset=utf-8");
            httpPost.setHeader("Accept", "application/json");
                httpPost.setEntity(new StringEntity(params, Charset.forName("UTF-8")));
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity());
            } else {
                log.info("请求失败");
            }
            log.info("返回数据result:{}" + result);
        } catch (IOException e) {
            log.error("请求异常");
        }
        return result;
    }

    /**
     * @Title: doPost
     * @Description: post请求
     * @param url
     * @param params
     * @return
     * @author Mundo
     */
    public static String doPost(String url, Map<String, Object> params) {
        String result = "";
        // 创建httpclient对象
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        try { // 参数键值对
            if (null != params && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>();
                NameValuePair pair = null;
                for (String key : params.keySet()) {
                    pair = new BasicNameValuePair(key, params.get(key).toString());
                    pairs.add(pair);
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                result = EntityUtils.toString(response.getEntity(), "utf-8");
//            } else {
//                log.info("请求失败！url:{}",url);
//            }
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            log.info("返回数据result:{}",result);
        } catch (Exception e) {
            log.error("请求失败");
            e.printStackTrace();
        } finally {
            if (null != httpPost) {
                // 释放连接
                httpPost.releaseConnection();
            }
        }
        return result;
    }

    /**
     * @Title: doPost
     * @Description: post请求
     * @param url
     * @param params
     * @return
     * @author Mundo
     */
    public static String doPostByHeader(String url, Map<String, Object> params) {
        String result = "";
        // 创建httpclient对象
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("contentType","application/json;charset=utf-8");

        try { // 参数键值对
            if (null != params && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>();
                NameValuePair pair = null;
                for (String key : params.keySet()) {
                    pair = new BasicNameValuePair(key, params.get(key).toString());
                    pairs.add(pair);
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                result = EntityUtils.toString(response.getEntity(), "utf-8");
//            } else {
//                log.info("请求失败！url:{}",url);
//            }
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            log.info("返回数据result:{}",result);
        } catch (Exception e) {
            log.error("请求失败");
            e.printStackTrace();
        } finally {
            if (null != httpPost) {
                // 释放连接
                httpPost.releaseConnection();
            }
        }
        return result;
    }

    /**
     * @Description: post请求参数放到body里
     * @Param: [url, proposalId]
     * @Return: java.lang.String
     * @Author: Jiangsy
     * @Date: 2020/8/6
    **/
    public static String postByBodyData(String url,String proposalId) {
        String result = "";
        //请求的body信息
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        //添加header
        httpPost.addHeader("X-Easymi-AppCode", "AppCode");
        httpPost.addHeader("X-Easymi-UserName", "UserName");
        //添加body
        ByteArrayEntity entity = null;
        try {
            entity = new ByteArrayEntity(proposalId.getBytes("UTF-8"));
            entity.setContentType("application/json");
        } catch (UnsupportedEncodingException e) {
            log.error("向服务器承保接口发起http请求,封装请求body时出现异常", e);
            throw new RuntimeException("向服务器承保接口发起http请求,封装请求body时出现异常", e);
        }
        httpPost.setEntity(entity);
        //执行post请求
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (ClientProtocolException e) {
            log.error("提交给服务器的请求，不符合HTTP协议", e);
            throw new RuntimeException("提交给服务器的请求，不符合HTTP协议", e);
        } catch (IOException e) {
            log.error("向服务器承保接口发起http请求,执行post请求异常", e);
            throw new RuntimeException("向服务器承保接口发起http请求,执行post请求异常", e);
        }
        log.info("状态码：" + response.getStatusLine());
        return result;
    }

    /**
     * get请求
     * @return
     */
    public static String doGet(String url) {
        try {
            HttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());

                return strResult;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    public static void main(String[] args) {

        //        ------------获取token-------------  //
//        String appid = "wx7621fa16f844249e";
//        String secret = "f45c2932ebebad373a5ee34364d78a88";
//        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
//
//                String s = doGet(url);
//        System.out.println(s);

        //{"access_token":"38_6wI2kCJs5rt58hoAJMmxy3SBsODHpkhktsvdoKbG80VVYhq7U7qnV6Ocudljb7DOWwc6tQ9BS87f4UKOR1DvY_qF2wtj6aR57lNLDCfLRyNjnDtyA2m8ybHIOhvZujCLEXYCLr6VvXj9U21EFRCaADARDO","expires_in":7200}
//
//        //{"access_token":"38_0JljSJqvaiR4gWLTRQ0HTLzWybP6HumNZj6HVQl-PG9b50kQYBqAdhpPITTwlKB5ECqPY-D-mPY5Jz5VZ4ipZn98mi9oX24Et9ixRdh8lN8e4IFj43SCNJlBasg8mZ6_4j9feTccK8KoTnOEIDNeACAOJT","expires_in":7200}

        //        ------------获取token-------------  //





//        https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID



        String token = "38_6wI2kCJs5rt58hoAJMmxy3SBsODHpkhktsvdoKbG80VVYhq7U7qnV6Ocudljb7DOWwc6tQ9BS87f4UKOR1DvY_qF2wtj6aR57lNLDCfLRyNjnDtyA2m8ybHIOhvZujCLEXYCLr6VvXj9U21EFRCaADARDO";

        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+token+"&next_openid=NEXT_OPENID";
        String s = doGet(url);
        System.out.println(s);









    }
}
