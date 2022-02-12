package com.liobio.demo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;;
import com.liobio.demo.dao.UserDao;
import com.liobio.demo.entity.UserEntity;
import com.liobio.demo.service.UserService;


@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public boolean save(UserEntity entity) {
        entity.setPwd("123456");
        entity.setRegisterTime(new Date());
        return super.save(entity);
    }

    @Override
    public Page<UserEntity> findPage(Integer pageNum, Integer pageSize, String search) {

        LambdaQueryWrapper<UserEntity> wrapper = Wrappers.<UserEntity>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(UserEntity::getName, search);
        }

        Page<UserEntity> UserPage = super.baseMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return UserPage;
    }



}