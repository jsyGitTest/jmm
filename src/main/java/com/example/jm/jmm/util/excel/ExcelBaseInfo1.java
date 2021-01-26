package com.example.jm.jmm.util.excel;

import lombok.Data;

import java.util.Date;

@Data
public class ExcelBaseInfo1 {
    @ExcelAnno(head = "评论")
    private String name;


}
