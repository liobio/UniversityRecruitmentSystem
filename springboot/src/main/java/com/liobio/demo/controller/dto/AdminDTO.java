package com.liobio.demo.controller.dto;

import lombok.Data;

import java.util.List;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName Admindto.java
 * @createTime 2022/03/04/23:18:00
 * @Description
 */
@Data
public class AdminDTO {
    private Integer id;
    private String name;
    private String pwd;
    private Integer level;
    private String avatarUrl;
    private String token;
}
