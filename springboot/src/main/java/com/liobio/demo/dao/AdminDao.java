package com.liobio.demo.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liobio.demo.entity.AdminEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
@Mapper
public interface AdminDao extends BaseMapper<AdminEntity> {



	
}
