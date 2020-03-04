package com.example.jm.jmm.util.excel;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD,ElementType.PARAMETER,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelAnno {
    String head() default "";
}