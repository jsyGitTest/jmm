package com.example.jm.jmm.util.jsoup;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 
 * @Param: 爬取b站弹幕
 * @Return: 
 * @Author: Jiangsy
 * @Date: 2020/11/20
**/
public class BiliUtil {

    public static void main(String[] args) throws Exception{
        //视频号
        String av = "BV1HJ411L7DP";
        String url = "https://api.bilibili.com/x/player/pagelist?bvid="+av+"&jsonp=jsonp";
        String result = HttpClientUtil.doGet(url);
        //获取cid
        String cid = JSONObject.parseObject(result).getJSONArray("data").getJSONObject(0).getString("cid");
        System.out.println("cid:{}"+cid);
        //获取弹幕打印到文件中
        getContent(cid);
    }

    /**
     * @Description:获取弹幕内容
     * @Param: [cid]
     * @Return: void
     * @Author: Jiangsy
     * @Date: 2020/11/20
    **/
    public static void getContent(String cid) throws Exception{
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
        HttpGet httpGet1 = new HttpGet("http://comment.bilibili.com/"+cid+".xml");
        CloseableHttpResponse httpResponse1 = closeableHttpClient.execute(httpGet1) ;
        String en = EntityUtils.toString(httpResponse1.getEntity(), "UTF-8");
        String c = "\">(.*?)<" ;
        Pattern a = Pattern.compile(c);
        Matcher m = a.matcher(en);
        File file = new File("/project/11.txt");
        if(file.exists()){
            file.delete();
        }
        OutputStream fos=new FileOutputStream("/project/11.txt");
        while(m.find()){
            String speak = m.group().replace("\">","") ;
            speak = speak.replace("<","") ;
            System.out.println(speak);
            String str=speak;
            str+="";
            fos.write(str.getBytes());
        }
    }

}
