package com.example.jm.jmm.util.jsoup;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsoupUtil4 {
    //抓取淘宝评论
    public static void main(String[] args) throws Exception {
            String url = "https://huaban.com/favorite/beauty/";
            // 动态模拟请求数据
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
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
                Elements select = doc.select("#waterfall");

                for (int i = 0; i < select.size(); i++) {
                    Element element = select.get(i);
                    Elements elementsByClass = element.getElementsByClass("img x layer-view");
                    for (int j = 0; j < elementsByClass.size(); j++) {
                        Element element1 = elementsByClass.get(j);
                        String attr = element1.getElementsByTag("img").attr("src");
                        attr = "https:" + attr + "/fw/480/format/webp";
                        System.out.println(attr);

                        String s = "/project/pic/" + UUID.randomUUID() + "";
                        ImageRequestUtils.downFile(attr, s);
                    }

                }

            }

        }

    }



