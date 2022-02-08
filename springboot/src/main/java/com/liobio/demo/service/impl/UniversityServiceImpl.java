package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.common.utils.PageUtils;
import com.liobio.common.utils.Query;

import com.liobio.demo.dao.UniversityDao;
import com.liobio.demo.entity.UniversityEntity;
import com.liobio.demo.service.UniversityService;


@Service("UniversityService")
public class UniversityServiceImpl extends ServiceImpl<UniversityDao, UniversityEntity> implements UniversityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UniversityEntity> page = this.page(
                new Query<UniversityEntity>().getPage(params),
                new QueryWrapper<UniversityEntity>()
        );

        return new PageUtils(page);
    }

}