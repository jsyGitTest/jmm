package com.example.jm.jmm.controller;


import com.example.jm.jmm.util.excel.ExcelBaseInfo;
import com.example.jm.jmm.util.excel.ExportExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Param: 生成excel并下载
 * @Return:
 * @Author: Jiangsy
 * @Date: 2020/3/4
**/
@RestController
public class DownLoanExcelController {

    @RequestMapping("download")
    public void download(HttpServletResponse response) throws Exception{

        ExportExcelUtil exportExcelUtil = new ExportExcelUtil();

        String title = "导出excel";
        List<ExcelBaseInfo> excelBaseInfos = new ArrayList<>();
        ExcelBaseInfo excelBaseInfo = new ExcelBaseInfo();
        excelBaseInfo.setBirthday(new Date());
        excelBaseInfo.setCollegeName("离市区远");
        excelBaseInfo.setDorm("哒哒哒哒哒哒");
        excelBaseInfo.setGradeName("哒哒哒哒哒哒多多");
        excelBaseInfo.setMajorName("顶顶顶顶");
        excelBaseInfo.setName("崔富贵");
        excelBaseInfo.setSex("男");
        excelBaseInfo.setStudentId("123123123");
        excelBaseInfo.setNation("江苏");

        ExcelBaseInfo excelBaseInfo1 = new ExcelBaseInfo();
        excelBaseInfo1.setBirthday(new Date());
        excelBaseInfo1.setCollegeName("离市区远");
        excelBaseInfo1.setDorm("哒哒哒哒哒哒");
        excelBaseInfo1.setGradeName("哒哒哒哒哒哒多多");
        excelBaseInfo1.setMajorName("顶顶顶顶");
        excelBaseInfo1.setName("崔富贵");
        excelBaseInfo1.setSex("男");
        excelBaseInfo1.setStudentId("123123123");
        excelBaseInfo1.setNation("江苏");
        excelBaseInfos.add(excelBaseInfo1);


        OutputStream os = response.getOutputStream();
        exportExcelUtil.exportExcelDownLoad(title,excelBaseInfos,os,"yyy-MM-dd");

        // 4 响应到客户端,弹出下载提示框
        try {
            this.setResponseHeader(response, "user.xls");
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 下载，生成响应流
     * @Param: [response, fileName]
     * @Return: void
     * @Author: Jiangsy
     * @Date: 2020/3/4
    **/
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
