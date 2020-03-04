package com.example.jm.jmm.util.excel;

import lombok.Data;

import java.util.Date;

@Data
public class ExcelBaseInfo {
    @ExcelAnno(head = "姓名")
    private String name;
    @ExcelAnno(head = "学号")
    private String studentId;
    @ExcelAnno(head = "学院")
    private String CollegeName;
    @ExcelAnno(head = "专业")
    private String majorName;
    @ExcelAnno(head = "年级")
    private String gradeName;
    @ExcelAnno(head = "宿舍")
    private String dorm;
    @ExcelAnno(head = "性别")
    private String sex;
    @ExcelAnno(head = "民族")
    private String nation;
    @ExcelAnno(head = "出生日期")
    private Date birthday;

}
