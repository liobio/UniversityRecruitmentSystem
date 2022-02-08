package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.common.utils.PageUtils;
import com.liobio.common.utils.Query;

import com.liobio.demo.dao.PoliticalAffiliationDao;
import com.liobio.demo.entity.PoliticalAffiliationEntity;
import com.liobio.demo.service.PoliticalAffiliationService;


@Service("PoliticalAffiliationService")
public class PoliticalAffiliationServiceImpl extends ServiceImpl<PoliticalAffiliationDao, PoliticalAffiliationEntity> implements PoliticalAffiliationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PoliticalAffiliationEntity> page = this.page(
                new Query<PoliticalAffiliationEntity>().getPage(params),
                new QueryWrapper<PoliticalAffiliationEntity>()
        );

        return new PageUtils(page);
    }

}