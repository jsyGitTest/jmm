package com.example.jm.jmm.util.freemakertopdf;

import com.itextpdf.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lujianing on 2017/5/7.
 */
public class JavaToPdfHtmlFreeMarker {


    private static Configuration freemarkerCfg = null;

    static {
        freemarkerCfg =new Configuration();
        //freemarker的模板目录
        try {
            freemarkerCfg.setDirectoryForTemplateLoading(new File(PathUtil.getCurrentPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {

        String savePdfPath = "/project/newPdf1.pdf";
        String fontPath = "/templates/simhei.ttf";
        String freemakerPath = "/templates/se.ftl";
        String imagePath = "file://"+PathUtil.getCurrentPath()+"/templates/";

        Map<String,Object> data = new HashMap();


        List<Content> contents = new ArrayList<Content>();
        Content content1 = new Content();
        Content content2 = new Content();
        content1.setContent("111");


        ArrayList<String> strings = new ArrayList<>();
        strings.add("444444");
        strings.add("55555");


        System.out.println(content1.getPicsList());

        content2.setContent("222");

        contents.add(content1);
        contents.add(content2);


        data.put("list",contents);


        String content = JavaToPdfHtmlFreeMarker.freeMarkerRender(data,freemakerPath);
        JavaToPdfHtmlFreeMarker.createPdf(content,savePdfPath,fontPath,imagePath);
    }


    public static void createPdf(String content,String savePdfPath,String fontPath,String imagePath) throws Exception {

//        // step 1
//        Document document = new Document();
//        // step 2
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
//        // step 3
//        document.open();
//        // step 4
//        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
//        fontImp.register(FONT);
//        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
//                new ByteArrayInputStream(content.getBytes()), null, Charset.forName("UTF-8"), fontImp);
//        // step 5
//        document.close();

        ITextRenderer render = new ITextRenderer();
        ITextFontResolver fontResolver = render.getFontResolver();
        fontResolver.addFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        // 解析html生成pdf
        render.setDocumentFromString(content);
        //解决图片相对路径的问题
        render.getSharedContext().setBaseURL(imagePath);
        render.layout();
        render.createPDF(new FileOutputStream(savePdfPath));

    }

    /**
     * freemarker渲染html
     */
    public static String freeMarkerRender(Map<String, Object> data, String htmlTmp) {
        Writer out = new StringWriter();
        try {
            // 获取模板,并设置编码方式
            Template template = freemarkerCfg.getTemplate(htmlTmp);
            template.setEncoding("UTF-8");
            // 合并数据模型与模板
            template.process(data, out); //将合并后的数据和模板写入到流中，这里使用的字符流
            out.flush();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }


    /**
     * freemarker渲染html
     */
    public static String freeMarkerRender1(List<Content> data, String htmlTmp) {
        Writer out = new StringWriter();
        try {
            // 获取模板,并设置编码方式
            Template template = freemarkerCfg.getTemplate(htmlTmp);
            template.setEncoding("UTF-8");
            // 合并数据模型与模板
            template.process(data, out); //将合并后的数据和模板写入到流中，这里使用的字符流
            out.flush();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
