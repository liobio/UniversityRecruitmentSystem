package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.common.utils.PageUtils;
import com.liobio.common.utils.Query;

import com.liobio.demo.dao.CompanyDao;
import com.liobio.demo.entity.CompanyEntity;
import com.liobio.demo.service.CompanyService;


@Service("CompanyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, CompanyEntity> implements CompanyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CompanyEntity> page = this.page(
                new Query<CompanyEntity>().getPage(params),
                new QueryWrapper<CompanyEntity>()
        );

        return new PageUtils(page);
    }

}