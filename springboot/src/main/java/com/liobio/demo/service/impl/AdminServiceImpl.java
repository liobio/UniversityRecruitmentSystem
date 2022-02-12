package com.liobio.demo.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.demo.dao.AdminDao;
import com.liobio.demo.entity.AdminEntity;
import com.liobio.demo.service.AdminService;


@Service("AdminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {

//    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    @Override
    public boolean save(AdminEntity entity) {
        entity.setPwd("123456");

        entity.setRegisterTime(new Date());
        return super.save(entity);
    }

    public boolean deleteById(long id){
        super.baseMapper.deleteById(id);
        return true;
    }
    @Override
    public Page<AdminEntity> findPage(Integer pageNum, Integer pageSize, String search){

        LambdaQueryWrapper<AdminEntity> wrapper = Wrappers.<AdminEntity>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(AdminEntity::getName, search);
        }

        Page<AdminEntity> adminPage = super.baseMapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return adminPage;

    }




}