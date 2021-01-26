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

public class JsoupUtil {
    public static void main(String[] args) throws Exception{
        String input = "毛巾";
// 需要爬取商品信息的网站地址
        //String url = "https://list.tmall.com/search_product.htm?q=" + input;
        String url = "https://rate.tmall.com/list_detail_rate.htm?itemId=630056407457&spuId=1868837056&sellerId=2616970884&order=3&currentPage=1&append=0&content=1&tagId=&posi=&picture=&groupId=&ua=098%23E1hve9vUvbpvUvCkvvvvvjiWP25OgjtEPFch1j3mPmPy0jtVRFLOtj3bn25vljlPi9hvCvvv9U8gvpvIvvvvk6CvvvvvvUUvphvvsQvv99CvpvAvvvmmvhCvmh%2BvvUUvphvUog9CvvOUvvVCJhTIvpvUvvmvKidEc0ZUvpCW2246vvw%2F1nAQ0fJ6EvLvYN79r1OKvwFpGwmZ5oEpDO7rqbVQWl4v1n2Iy2Wl7gzBif6zH2pOS4LrsfK6nHJ3Ib0ySfh3Zi7vQR9t%2B9vCvvOvUvvvphvRvpvhvv2MMs9Cvvpvvvvv&needFold=0&_ksTS=1605685731732_383&callback=jsonp384";
// 动态模拟请求数据
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
// 模拟浏览器浏览（user-agent的值可以通过浏览器浏览，查看发出请求的头文件获取）
        httpGet.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
        httpGet.setHeader("referer", "https://detail.tmall.com/item.htm?id=615031682507&sku_properties=132694671:4443022");
        httpGet.setHeader("cookie", "lid=agonijsy; enc=40nYAPr0HUCk25Flk4psfPmRlLG6F9fRQN6%2BR5rr08%2FI0HFZUGzgl9IA8zkjT%2BVHQX6NharXYJnt3ni42HkxpQ%3D%3D; hng=CN%7Czh-CN%7CCNY%7C156; t=95610264fbb6cdfbdbf56c85a64d1084; tracknick=agonijsy; _tb_token_=53ae13676d5b6; cookie2=16d64f2d8ad48e7ed983f057676d5757; cna=7zjrF6T9bG8CAdORQ6rOxXyq; dnk=agonijsy; uc1=pas=0&cookie14=Uoe0abDDhePONA%3D%3D&existShop=false&cookie21=U%2BGCWk%2F7p4mBoUyS4E9C&cookie15=UtASsssmOIJ0bQ%3D%3D&cookie16=URm48syIJ1yk0MX2J7mAAEhTuw%3D%3D; uc3=id2=Uoe1hdDZA9SHmA%3D%3D&nk2=AnZwyLViBHc%3D&lg2=UIHiLt3xD8xYTw%3D%3D&vt3=F8dCufJL%2FCJEKQViE%2Bc%3D; uc4=nk4=0%40AJ0xRHLDa7jHI%2F0ud09irLq0iw%3D%3D&id4=0%40UO%2BzOmlfkblJvztSTwRanRxHA5%2BF; lgc=agonijsy; sgcookie=E100n2KYQNZFj0gMkgzO%2B%2B%2FujKCmIHCXwDCoaFiuMkCc%2FrKJIMY1VSysqw5%2BtS0HFyWXl9SnLLFgx5e0YIx6WAPjrg%3D%3D; csg=21561164; xlly_s=1; _m_h5_tk=5f240a0500560d712fc4a37e9bcc9c41_1605675134113; _m_h5_tk_enc=ac3e735157623168162058ecd123c0fa; l=eBjkI4zuO2CAWxxvBOfwourza77OSIRAguPzaNbMiOCP9E195kLcWZ78Vk8pC3GVh6-kR3koYfLQBeYBcnV0x6aNa6Fy_Ckmn; isg=BEZGKtc8ZeVduDEqH8tePmp8lzrIp4phNtJZHzBvMmlBM-ZNmDfacSzFC2__m4J5; tfstk=cckPBBmd6J0jzfwB68wFNGURMNCRZw3n5trLZX8Ic75X_lNli7_LmO7L0lU9n7f..");
        CloseableHttpResponse response = httpclient.execute(httpGet);
// 获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        try {
            HttpEntity entity = response.getEntity();
            // 如果状态响应码为200，则获取html实体内容或者json文件
            if(statusCode == 200){
                String html = EntityUtils.toString(entity, Consts.UTF_8);
                // 提取HTML得到商品信息结果
                Document doc = null;
                // doc获取整个页面的所有数据
                doc = Jsoup.parse(html);
                //输出doc可以看到所获取到的页面源代码
                String text = doc.body().text();
                System.out.println(text);
                System.out.println("=====================");


                String content = text.replaceAll("jsonp384\\(","").replaceAll("\\)","");


                JSONObject object = JSONObject.parseObject(content);


                JSONArray jsonArray = object.getJSONObject("rateDetail").getJSONArray("rateList");
                for (int i = 0; i < jsonArray.size(); i++) {
                    String rateContent = jsonArray.getJSONObject(i).getString("rateContent");
                    System.out.println("评价第" +i+ "条"  +"内容:"+rateContent);

                }

                EntityUtils.consume(response.getEntity());
            } else {
                // 消耗掉实体
                EntityUtils.consume(response.getEntity());
            }
        } finally {
            response.close();
        }
    }
}
