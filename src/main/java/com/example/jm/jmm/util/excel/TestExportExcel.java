package com.example.jm.jmm.util.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestExportExcel {
    public static void main(String[] args) throws Exception {

        ExportExcelUtil exportExcelUtil = new ExportExcelUtil();
        FileOutputStream outputStream = new FileOutputStream(new File("/project/1.xls"));

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


        exportExcelUtil.exportExcel(title,excelBaseInfos,outputStream,"yyy-MM-dd");



    }
}
