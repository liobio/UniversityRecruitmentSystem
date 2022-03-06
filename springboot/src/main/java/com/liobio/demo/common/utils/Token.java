package com.liobio.demo.common.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.liobio.demo.entity.AdminEntity;
import com.liobio.demo.service.AdminService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName token.java
 * @createTime 2022/03/04/22:41:00
 * @Description
 */
public class Token {
    private static AdminService staticAdminService;

    @Resource
    private AdminService adminService;

    @PostConstruct
    public void setAdminService() {
        staticAdminService = staticAdminService;
    }

    /**
     * 生成token
     *
     * @return
     */
    public static String genToken(String entityId, String sign) {
        return JWT.create().withAudience(entityId) // 将 admin id 保存到 token 里面,作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(), 1)) // 480小时后token过期
                .sign(Algorithm.HMAC256(sign)); // 以 password 作为 token 的密钥
    }

    /**
     * 获取当前登录的用户信息
     *
     * @return admin对象
     */
    public static AdminEntity getCurrentAdmin() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (StrUtil.isNotBlank(token)) {
                String adminId = JWT.decode(token).getAudience().get(0);
                return staticAdminService.getById(Integer.valueOf(adminId));
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
