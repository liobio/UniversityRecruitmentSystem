package com.liobio.demo.controller.dto;

import lombok.Data;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName AdminPwdDTO.java
 * @createTime 2022/03/04/23:28:00
 * @Description
 */
public class AdminPwdDTO {
    @Data
    public class adminPwdDTO {
        private String Name;
        private String pwd;
        private String newPwd;
    }
}
