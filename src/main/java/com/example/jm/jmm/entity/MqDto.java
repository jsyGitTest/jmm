package com.example.jm.jmm.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
//链式set
@Accessors(chain = true)
public class MqDto implements Serializable{
    private String name;
    private String address;
}
