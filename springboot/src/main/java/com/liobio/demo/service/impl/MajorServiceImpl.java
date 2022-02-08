package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.common.utils.PageUtils;
import com.liobio.common.utils.Query;

import com.liobio.demo.dao.MajorDao;
import com.liobio.demo.entity.MajorEntity;
import com.liobio.demo.service.MajorService;


@Service("MajorService")
public class MajorServiceImpl extends ServiceImpl<MajorDao, MajorEntity> implements MajorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MajorEntity> page = this.page(
                new Query<MajorEntity>().getPage(params),
                new QueryWrapper<MajorEntity>()
        );

        return new PageUtils(page);
    }

}