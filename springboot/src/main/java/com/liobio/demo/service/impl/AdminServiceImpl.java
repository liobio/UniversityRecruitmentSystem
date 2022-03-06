package com.liobio.demo.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liobio.demo.common.utils.Constants;
import com.liobio.demo.common.utils.Result;
import com.liobio.demo.common.utils.Token;
import com.liobio.demo.controller.dto.AdminDTO;
import com.liobio.demo.exception.ServiceException;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.demo.dao.AdminDao;
import com.liobio.demo.entity.AdminEntity;
import com.liobio.demo.service.AdminService;


@Service("AdminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {

    private static final Log LOG = Log.get();
    @Override
    public boolean save(AdminEntity entity) {
        entity.setPwd("123456");

        entity.setRegisterTime(new Date());
        return super.save(entity);
    }
    @Override
    public AdminDTO login(AdminDTO DTO){
//        AdminDTO res=this.getBaseMapper().selectOne(Wrappers.<AdminEntity>lambdaQuery()
//                .eq(AdminEntity::getName,entity.getName())
//                .eq(AdminEntity::getPwd,entity.getPwd()));
//        if(res == null){
//            return null;
//        }
//        else {
//            return res;
//        }
        AdminEntity one = getAdminInfo(DTO);
        if (one != null) {
            BeanUtil.copyProperties(one, DTO, true);
            // 设置token
            String token = Token.genToken(one.getId().toString(), one.getPwd());
            DTO.setToken(token);
            System.out.println(one.getAvatarUrl());
            DTO.setAvatarUrl(one.getAvatarUrl());
//            Integer level= one.getLevel(); // ROLE_ADMIN
            // 设置用户的菜单列表
//            List<Menu> roleMenus = getRoleMenus(role);
//            userDTO.setMenus(roleMenus);
            return DTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    public int deleteById(long id){

        return this.getBaseMapper().deleteById(id);
    }
    @Override
    public Page<AdminEntity> findPage(Integer pageNum, Integer pageSize, String search){

        LambdaQueryWrapper<AdminEntity> wrapper = Wrappers.<AdminEntity>lambdaQuery();
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(AdminEntity::getName, search);
        }

        Page<AdminEntity> adminPage = this.getBaseMapper().selectPage(new Page<>(pageNum,pageSize),wrapper);
        return adminPage;

    }

    private AdminEntity getAdminInfo(AdminDTO adminDTO) {
        QueryWrapper<AdminEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", adminDTO.getName());
        queryWrapper.eq("pwd", adminDTO.getPwd());
        AdminEntity one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }




}