package com.liobio.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liobio.demo.entity.AdminEntity;



/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
public interface AdminService extends IService<AdminEntity> {
    Page<AdminEntity> findPage(Integer pageNum, Integer pageSize, String search);

    int deleteById(long  id);

    boolean login(AdminEntity entity);
}

