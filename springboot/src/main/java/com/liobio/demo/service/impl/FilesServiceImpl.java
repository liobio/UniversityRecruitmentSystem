package com.liobio.demo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.demo.dao.FilesDao;
import com.liobio.demo.entity.FilesEntity;
import com.liobio.demo.service.FilesService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("FilesService")
public class FilesServiceImpl extends ServiceImpl<FilesDao, FilesEntity> implements FilesService {

    @Override
    public Page<FilesEntity> findPage(Integer pageNum, Integer pageSize, String search){

        LambdaQueryWrapper<FilesEntity> wrapper = Wrappers.<FilesEntity>lambdaQuery();
        wrapper.eq(FilesEntity::getIsDelete, false);
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(FilesEntity::getName, search);
        }
        Page<FilesEntity> Page = this.getBaseMapper().selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Page;

    }

    @Override
    public int deleteById(Integer id) {
        FilesEntity filesEntity=getBaseMapper().selectById(id);
        filesEntity.setIsDelete(true);
        return this.baseMapper.updateById(filesEntity);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {

        QueryWrapper<FilesEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", ids);
        List<FilesEntity> files = this.baseMapper.selectList(queryWrapper);
        for (FilesEntity file : files) {
            file.setIsDelete(true);
            this.baseMapper.updateById(file);
        }
        return 1;
    }


}