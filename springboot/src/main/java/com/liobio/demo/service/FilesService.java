package com.liobio.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liobio.demo.entity.AdminEntity;
import com.liobio.demo.entity.FilesEntity;

import java.util.List;


/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
public interface FilesService extends IService<FilesEntity> {
    Page<FilesEntity> findPage(Integer pageNum, Integer pageSize, String search);

    int deleteById(Integer id);

    int deleteBatch(List<Integer> ids);
}

