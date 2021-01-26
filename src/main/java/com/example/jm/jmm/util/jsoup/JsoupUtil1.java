package com.example.jm.jmm.util.jsoup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class JsoupUtil1 {
    //抓取淘宝评论
    public static void main(String[] args) throws Exception{
        List<Content> contents = new ArrayList<Content>();
        for (int e = 1; e < 10; e++) {
            String url = "https://rate.taobao.com/feedRateList.htm?auctionNumId=581201263103&userNumId=3415741774&currentPageNum="+e+"&pageSize=20&rateType=3&orderType=sort_weight&attribute=&sku=&hasSku=false&folded=0&ua=137%23Q699hE9o9IgD%2FpW4tBHnnojGIn9bYsKMxkKF%2Fl6EdfXn4OqCAWieIy7uVv3Cl8HwWVC6D%2BqZV1TI4KCj86xY3wiEc3a5MXo%2B2YRhREMiwSPgJJGvYRPPs4Pm41zMVLpmTq738MncNOpAPF3OJTiEGGL3rdVR5LIkZnqOLZttfsvdyKwQ4fItrBLKXWIZGJJTxnlC8j%2FCFeuyp9lPPGI9QsG71d9uDMLYVIEUk9HGEJvztYqJc5ZRWADaW9XbF3FMTmGEGVIdEOX9VHQZB%2BbV01GRcSlMVDUFdEghN7Ueq2FXd8STk4kqv%2F5Y5jnLlxczg3wmGRMgWUHvOIcYzEzmhgX%2B8rkavh27HW5Ed63R2EBNspA3mBChr5Gij68YoIXvehzMB71vEAmIZq0wqWePHqWP6iEChwUaB9SloV8DVtbTEwCjN7ZbKfk9vfxCjBb%2FXTQ%2FEylwb3gbQbpVIuAHxZWHwS873srxB8lBGsGtCL8af5ScYSJS1qv5h8GmQ%2B2e%2BGLiB0OczJAI%2B1aMYrJx19QvVYJPQefJ%2BZDVpRUc1AIy%2BtpWpbMc0ZQiqtpcQonJ%2BZg4pTU41Aey%2BtiVESDvEdt6rXC4ng897pNppRJc1IEI%2BXipYSJS1vtHpXpcQono%2BZXVpkUm1AEyM9jaBlGt9%2BVUzeCisUAnRwboN8p2cV34E7NeFW6FUSuTVeMKUwwJImSDc4CvD52DdCVUOB6QNFkz3TP90r3BA7XsBQo8fd1K5%2BB2L9SM0DDoUfor7RcI8PSImtrCbDNMYl2lTIz1tn%2FA4HJEHqpgULa%2Fd9nW2NYmMtP9hVmtpXFbhBA8JqCFTwVeSp6wP4hbRqr2jDJ9VYr7IV5zn2yUDE%2B5JzDSNxKyoiQ%2BteGHXLpq7IfBFBpjEZcAC4j2rRwZ3hw0VnN9VFMUp098h0V8283AIrSFMi8j4MJuO4WPzcLyTmRDHbnXc5TCFY4%2BNWeaDsP%2BEPM%2FAFiPEGgzBXGobMP1iSPvkeHUkES3BIZCM%2F7nfEPykTLf1fre5Z7vCTO%2BsAgW0uTajM7lFEjfgKAiGCvQZX%2BqVSaXArSz02XHDUY7HJq3JaUR%2BHSmJtpdOaH8FYb%2FFA2QkkNPusBz5jvchcyiP%2BaUKDswHvj%3D&_ksTS=1605689080588_1245&callback=jsonp_tbcrate_reviews_list";
            // 动态模拟请求数据
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
// 模拟浏览器浏览（user-agent的值可以通过浏览器浏览，查看发出请求的头文件获取）
            httpGet.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
            httpGet.setHeader("referer", "");
            httpGet.setHeader("cookie", "hng=CN%7Czh-CN%7CCNY%7C156; ali_ab=1.202.141.102.1566547196929.6; tracknick=agonijsy; tg=0; enc=40nYAPr0HUCk25Flk4psfPmRlLG6F9fRQN6%2BR5rr08%2FI0HFZUGzgl9IA8zkjT%2BVHQX6NharXYJnt3ni42HkxpQ%3D%3D; t=95610264fbb6cdfbdbf56c85a64d1084; cookie2=16d64f2d8ad48e7ed983f057676d5757; v=0; cna=7zjrF6T9bG8CAdORQ6rOxXyq; _samesite_flag_=true; lgc=agonijsy; dnk=agonijsy; miid=2046293994528388276; thw=cn; _m_h5_tk=065afaa6e300cde3da8cc7acfb486149_1605688007837; _m_h5_tk_enc=0a3a3522ca25cf8387701d0f57352675; xlly_s=1; UM_distinctid=175d9e28f72440-0e03b5753ad385-32667006-fa000-175d9e28f73afb; _tb_token_=f153e338537e3; sgcookie=E100wckveT0bRVXGudaNM%2B0LJylc2BmE5Wr8tEVvaRbKkpXwgv7Qj0syOj3Cr7q%2BZXzbeYLb%2FQOOFhnlAdUCVu6xyQ%3D%3D; unb=1617116984; uc3=vt3=F8dCufwtEHjhYcDri6I%3D&nk2=AnZwyLViBHc%3D&lg2=VFC%2FuZ9ayeYq2g%3D%3D&id2=Uoe1hdDZA9SHmA%3D%3D; csg=b244bd4f; cookie17=Uoe1hdDZA9SHmA%3D%3D; skt=a9dec7f22b889dff; existShop=MTYwNTY4NjQ1Mg%3D%3D; uc4=nk4=0%40AJ0xRHLDa7jHI%2F0udvQi%2FKZRpA%3D%3D&id4=0%40UO%2BzOmlfkblJvztSTwRb12ydzBoB; _cc_=UIHiLt3xSw%3D%3D; _l_g_=Ug%3D%3D; sg=y48; _nk_=agonijsy; cookie1=UtAD6GhOJBlJ3lfZR7uY2jTLiijHyMk80zCvMf76qaU%3D; mt=ci=20_1; uc1=cookie21=WqG3DMC9Fb5mPLIQo9kR&cookie14=Uoe0aDqwdxWEuQ%3D%3D&existShop=false&pas=0&cookie16=UIHiLt3xCS3yM2h4eKHS9lpEOw%3D%3D&cookie15=V32FPkk%2Fw0dUvg%3D%3D; x5sec=7b22726174656d616e616765723b32223a226338643439613466643466373031613832333464646134383865303731653539434e3639302f3046454f2f2b68667a367475724730514561444445324d5463784d5459354f4451374d513d3d227d; tfstk=cu5RBOOngr3Jms8A7TemORVOudpRaVaJx4tZ9PwauGqu_YlKOs41s1HyI8Tt2IUA.; l=eBQ3iEwIO2CACHbwBO5Zlurza77T0Idf1sPzaNbMiIncC6nFMmp9__-QKh2mGLKRR8XAG7LB4YmE6ewtuebg7_LX7w3xU-Ctl6D2B; isg=BISEfm2Zh8PESTMkMRxXUYXRVQR2nagHAPjbkZ4ki89vySeTxqw1l-cvCWERUeBf");
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

                    System.out.println(text);
                    String content = text.replaceAll("jsonp_tbcrate_reviews_list\\(", "").replaceAll("\\)", "");


                    JSONObject object = JSONObject.parseObject(content);

                    JSONArray jsonArray = object.getJSONArray("comments");

                    for (int i = 0; i < jsonArray.size(); i++) {
                        Content content2 = new Content();
                        String content1 = jsonArray.getJSONObject(i).getString("content");
                        System.out.println(content1);

                        content2.setContent(content1);
                        //获取图片

                        JSONArray photos = jsonArray.getJSONObject(i).getJSONArray("photos");
                        ArrayList<Pics> pics1 = new ArrayList<>();

                        if (photos.size() > 0) {
                            for (int j = 0; j < photos.size(); j++) {
                                Pics pics = new Pics();
                                String url1 = photos.getJSONObject(j).getString("url");
                                String urlrr = "https:" + url1;
                                String s = "/project/pic/" + UUID.randomUUID() + ".png";
                                ImageRequestUtils.downFile(urlrr, s);
                                pics.setUrl(s);
                                pics1.add(pics);
                            }
                        }
                        content2.setPicsList(pics1);
                        contents.add(content2);
                    }

                }



                EntityUtils.consume(response.getEntity());
            }


        System.out.println("-------------------");
        System.out.println(JSON.toJSONString(contents));
        System.out.println(contents.size());
        //PdfUtils.getPdf(contents);

    }
}
