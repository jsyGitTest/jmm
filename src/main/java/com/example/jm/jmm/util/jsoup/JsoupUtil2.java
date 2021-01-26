package com.example.jm.jmm.util.jsoup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.jm.jmm.util.excel.ExcelBaseInfo;
import com.example.jm.jmm.util.excel.ExcelBaseInfo1;
import com.example.jm.jmm.util.excel.ExportExcelUtil;
import com.example.jm.jmm.util.freemakertopdf.Content;
import com.example.jm.jmm.util.freemakertopdf.PdfUtils;
import com.example.jm.jmm.util.freemakertopdf.Pics;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsoupUtil2 {
    //抓取淘宝评论
    public static void main(String[] args) throws Exception{
        List<Content> contents = new ArrayList<Content>();

        List<ExcelBaseInfo1> excelBaseInfos1 = new ArrayList<>();

        for (int e = 1; e < 3; e++) {
            String url = "https://rate.tmall.com/list_detail_rate.htm?itemId=562922655211&spuId=914065068&sellerId=3073065278&order=3&currentPage=1&append=0&content=1&tagId=&posi=&picture=&groupId=&ua=098%23E1hvqQvWvRyvUvCkvvvvvjiWP259ljtERF5ytjivPmP9QjnvPss96j1UR25v6j1E9vhvHHifLPYxzHi47rYKtMAD7e140rYUdvhvmpmv0n1dvvCmVgOCvvpv9hCvi9hvCvvvpZpvvpvVvvBvpvvvmvhvLvh%2B%2FSIafBKKyiD%2Bm7zpdigO55lvD70fd346NB3r68TNe3r6BJF9Vi%2B4HFXXiXhpVE01Ux8x9EkfjLyDZacEn1mAdcvrYE7reTg7EcTgvpvIvvCvxQvvvvvvvhxHvvmvhpvvBZZvvUhpvvCHBpvvv7yvvhxHvvvC4O9CvvOCvhECgnkIvpvUvvCCnEPX%2B5pRvpvhvv2MMs9CvvpvvhCvRvhvCvvvphv%3D&needFold=0&_ksTS=1605855800803_968&callback=jsonp969";
            // 动态模拟请求数据
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            // 模拟浏览器浏览（user-agent的值可以通过浏览器浏览，查看发出请求的头文件获取）
            httpGet.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
            httpGet.setHeader("referer", "https://detail.tmall.com/item.htm?spm=a230r.1.14.148.700b4961B9L9DD&id=562922655211&ns=1&abbucket=9");
            httpGet.setHeader("cookie", "lid=agonijsy; enc=40nYAPr0HUCk25Flk4psfPmRlLG6F9fRQN6%2BR5rr08%2FI0HFZUGzgl9IA8zkjT%2BVHQX6NharXYJnt3ni42HkxpQ%3D%3D; hng=CN%7Czh-CN%7CCNY%7C156; t=95610264fbb6cdfbdbf56c85a64d1084; tracknick=agonijsy; cookie2=16d64f2d8ad48e7ed983f057676d5757; cna=7zjrF6T9bG8CAdORQ6rOxXyq; dnk=agonijsy; lgc=agonijsy; xlly_s=1; _m_h5_tk=809a237cb97f255ac4ee3e4897e92eb1_1605757825546; _m_h5_tk_enc=7d4c173ec7103d1e5c5d435e372e3828; uc1=cookie16=URm48syIJ1yk0MX2J7mAAEhTuw%3D%3D&cookie14=Uoe0aDvYwnulxQ%3D%3D&existShop=false&cookie21=WqG3DMC9Fb5mPLIQo9kR&cookie15=VFC%2FuZ9ayeYq2g%3D%3D&pas=0; uc3=vt3=F8dCufwsA5OQooWgr7I%3D&id2=Uoe1hdDZA9SHmA%3D%3D&lg2=UIHiLt3xD8xYTw%3D%3D&nk2=AnZwyLViBHc%3D; _l_g_=Ug%3D%3D; uc4=nk4=0%40AJ0xRHLDa7jHI%2F0udvVDKFKcdg%3D%3D&id4=0%40UO%2BzOmlfkblJvztSTwRb1rSMQbQG; unb=1617116984; cookie1=UtAD6GhOJBlJ3lfZR7uY2jTLiijHyMk80zCvMf76qaU%3D; login=true; cookie17=Uoe1hdDZA9SHmA%3D%3D; _nk_=agonijsy; sgcookie=E100Ujv6ze%2BN4W4wLcziEJOiiOWX5VvgSjc6oguVHIvxZqTgW8tpXiadeVTXvkDRlKxe%2BYEGGOA5fTMZL4%2F6he0nJQ%3D%3D; sg=y48; csg=7431073b; _tb_token_=e41139a41e83a; x5sec=7b22726174656d616e616765723b32223a223362643966306133343038333262326439346561356637343830353133306238434f4763312f3046454c4751346365556a65487248426f4d4d5459784e7a45784e6a6b344e447378227d; tfstk=cUAOBnf0T2UTfKQpzdH3GLjLNxtAZC3OmPszM4MVUJBg79PAiyOkwRWoCaEO92C..; l=eBjkI4zuO2CAWTo6BO5Zourza77OeIRb8sPzaNbMiInca6ZdNFs88NQVPPcDldtjgtCjuetrEDl9RREJ8FzNwZqhuJ1REpZaoxvO.; isg=BICAd-zey_Z4U7fY1RXA7MC6UQhSCWTTbNRfDfoR8hstdSGfohivY0oDjd21RRyr");
            CloseableHttpResponse response = httpclient.execute(httpGet);
            // 获取响应状态码
            int statusCode = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();
                // 如果状态响应码为200，则获取html实体内容或者json文件
                if (statusCode == 200) {
                    String html = EntityUtils.toString(entity, Consts.UTF_8);
                    // 提取HTML得到商品信息结果
                    Document doc = null;
                    // doc获取整个页面的所有数据
                    doc = Jsoup.parse(html);
                    //输出doc可以看到所获取到的页面源代码
                    String text = doc.body().text();
                    String content = text.replaceAll("jsonp969\\(", "").replaceAll("\\)", "");
                    JSONObject object = JSONObject.parseObject(content);
                    JSONArray jsonArray = object.getJSONObject("rateDetail").getJSONArray("rateList");
                    OutputStream fos = new FileOutputStream("/project/33.txt");
                    for (int i = 0; i < jsonArray.size(); i++) {
                        String rateContent = jsonArray.getJSONObject(i).getString("rateContent");
                        fos.write(rateContent.getBytes());
                        JSONArray videoList = jsonArray.getJSONObject(i).getJSONArray("videoList");
                        if(videoList.size()>0){
                            for (int j = 0; j < videoList.size(); j++) {
                                String coverUrl = videoList.getJSONObject(j).getString("coverUrl");
                                String urlrr = "https:" + coverUrl;
                                String s = "/project/pic/" + UUID.randomUUID() + ".png";
                                ImageRequestUtils.downFile(urlrr, s);
                            }
                        }

                    }

                }



                EntityUtils.consume(response.getEntity());
            }



    }
    }

