package com.example.jm.jmm.util.jsoup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.jm.jmm.util.freemakertopdf.Content;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsoupUtil3 {
    //抓取淘宝评论
    public static void main(String[] args) throws Exception {
        List<String> contents = new ArrayList<String>();
        for (int e = 1; e < 2; e++) {
            String url = "https://rate.taobao.com/feedRateList.htm?auctionNumId=581201263103&userNumId=3415741774&currentPageNum=1&pageSize=20&rateType=&orderType=sort_weight&attribute=&sku=&hasSku=false&folded=0&ua=137%23eAc9hE9o9ah%2FnmDM4EHl0jAGInQegDsqM3n%2Bp80fMgaDbJ4imxrHr5a0RgFmg7wRbgRUsO1DJ7ng7sqPd%2B%2BgMGZSo8izQO6f7jbA%2B0R0P5u%2FAvojAsIQYGpUgp5socUwluljIJ8WIcPD7H274RlMA2Ow%2F%2Bb36jcUyXdydNv7vR8o971qKYANTtu%2By7jx3%2F423FNWYyfQZT3sI6OXe7sUNwHKhygSP7qbANvUQhy5FDfoz5o24b98lN6qa9MEzhyUOCjsDzdsBQL8vVKJ1sG1sPxRebuzRw2wox6nCJ6F45rcs8FmfLHizrQOWHR7REi%2BZAEhAe7%2FMu8M8V6IzpWvBKCupObQbFAW89ItFayvW1kd10x1UyW1yKIVMsLe8%2FlqteXeaa7MGIw2uP6iHY10EaZa1jBXK9QAqLaVncOqn0ZzOGzZ7pi3MEcnbY5e4Upsws3DAiqxcIcBxeH7n8IQYSJS1qgyWiqmQefoU7VyKzfm1Iey%2BtiVYSUSllQypktp749M%2BZg0pkUc1Aey%2B5WVQSsS1lQypXC9nK89kdhnpTszGo%2FXPtpVYTUx1qECpXpcQeno5PWVpkUc1AEy%2BpipYSJS1qLR9hReDfP9iIS23MWKVKiCBI5rfUW1N792joVmodV1DbU5iRfYWUJNxUbXvzUsvBbEGMSgixQQumzANIyNsXzaEfG0yZ%2B3Imbd%2F8at80g7x68hHLoW%2BwOnmYFQggHV5pbLpifAPkjZvqKL0sQNZGdXB9Cu%2FSR0QImiB1tO0S60yMilA8VDDfpiR9A8aI3wuhIkhDVP2LsL03Cc9bf4lc3Z2xmUBwam9jv1Avkb5TZT7Hm%2F3%2BVNTH9cm08d3vSCZwSpGS6rYy%2B54wj1v6CfG0Wm6sK3Kz7e5p18elTWM0Wvwd6bci42yhGEZ0%2FAdLrjh8oan0Y2mem%2FXKaOyvd8Hrc12apj1MOZNjpgYY4CMVkOrRWWnfsIsusScqv1qMqScpK%3D&_ksTS=1605755541262_1150&callback=jsonp_tbcrate_reviews_list";
            // 动态模拟请求数据
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
// 模拟浏览器浏览（user-agent的值可以通过浏览器浏览，查看发出请求的头文件获取）
            httpGet.setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
            httpGet.setHeader("referer", "https://item.taobao.com/item.htm?spm=a230r.1.14.15.74a13848bFGcQL&id=581201263103&ns=1&abbucket=9");
            httpGet.setHeader("cookie", "hng=CN%7Czh-CN%7CCNY%7C156; ali_ab=1.202.141.102.1566547196929.6; tracknick=agonijsy; tg=0; enc=40nYAPr0HUCk25Flk4psfPmRlLG6F9fRQN6%2BR5rr08%2FI0HFZUGzgl9IA8zkjT%2BVHQX6NharXYJnt3ni42HkxpQ%3D%3D; t=95610264fbb6cdfbdbf56c85a64d1084; cookie2=16d64f2d8ad48e7ed983f057676d5757; v=0; cna=7zjrF6T9bG8CAdORQ6rOxXyq; _samesite_flag_=true; lgc=agonijsy; dnk=agonijsy; miid=2046293994528388276; thw=cn; xlly_s=1; UM_distinctid=175d9e28f72440-0e03b5753ad385-32667006-fa000-175d9e28f73afb; mt=ci=20_1; _tb_token_=e41139a41e83a; _m_h5_tk=e9207d5a5d04e3351c325af9f0a00602_1605763850254; _m_h5_tk_enc=94a96f69490c33a36a9a85ddfa7188a4; sgcookie=E100dmrPfebV0V%2FIj7k2slNEysad60EtmY%2FYqEIIy5tXdCfNgcVOObu%2BcmBiUcWEvxRCtLMCEkqis0Pyi9jIvyrHVQ%3D%3D; unb=1617116984; uc1=cookie14=Uoe0aDvZSNyyjg%3D%3D&cookie15=W5iHLLyFOGW7aA%3D%3D&existShop=false&pas=0&cookie21=UtASsssmeW6lpyd%2BB%2B3t&cookie16=V32FPkk%2FxXMk5UvIbNtImtMfJQ%3D%3D; uc3=id2=Uoe1hdDZA9SHmA%3D%3D&lg2=WqG3DMC9VAQiUQ%3D%3D&vt3=F8dCufwsA5S4toQnhpk%3D&nk2=AnZwyLViBHc%3D; csg=aabecd68; cookie17=Uoe1hdDZA9SHmA%3D%3D; skt=2b1920a8fc539985; existShop=MTYwNTc1NTI5MA%3D%3D; uc4=id4=0%40UO%2BzOmlfkblJvztSTwRb1rUGHOPb&nk4=0%40AJ0xRHLDa7jHI%2F0udvVCR2jacA%3D%3D; _cc_=Vq8l%2BKCLiw%3D%3D; _l_g_=Ug%3D%3D; sg=y48; _nk_=agonijsy; cookie1=UtAD6GhOJBlJ3lfZR7uY2jTLiijHyMk80zCvMf76qaU%3D; tfstk=cLCPBI_KBBjby7AQBQOEFRnBhnoRZajhfj8pE9r1LeJQYw9liaipofopuFKTiLf..; l=eBQ3iEwIO2CACnKXBO5Cnurza779uIObzsPzaNbMiInca6dh_EqjVNQVP8D98dtjgtCvletrEDl9RR3B8L4N2ETNJqHzH13jnxxN.; isg=BCsr-c8B8MdLESy58tFgdPYEukkVQD_C023krJ2pE2rGPEmeJRENEvjalnxSHJe6");
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
                File file = new File("/project/22.txt");

                if (file.exists()) {
                    file.delete();
                }
                OutputStream fos = new FileOutputStream("/project/22.txt");

                for (int i = 0; i < jsonArray.size(); i++) {
                    String content1 = jsonArray.getJSONObject(i).getString("content");
                    if (!content1.equals("评价方未及时做出评价,系统默认好评!")) {
                        contents.add(content1);
                        System.out.println(content1);
                        fos.write(content1.getBytes());
                    }
                    JSONArray photos = jsonArray.getJSONObject(i).getJSONArray("photos");

                    if (photos.size() > 0) {
                        for (int j = 0; j < photos.size(); j++) {
                            String url1 = photos.getJSONObject(j).getString("url");
                            String urlrr = "https:" + url1;
                            String s = "/project/pic/" + UUID.randomUUID() + ".png";
                            ImageRequestUtils.downFile(urlrr, s);
                        }
                    }
                }
            }

        }

    }



}
