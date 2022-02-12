package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.demo.dao.PoliticalAffiliationDao;
import com.liobio.demo.entity.PoliticalAffiliationEntity;
import com.liobio.demo.service.PoliticalAffiliationService;


@Service("PoliticalAffiliationService")
public class PoliticalAffiliationServiceImpl extends ServiceImpl<PoliticalAffiliationDao, PoliticalAffiliationEntity> implements PoliticalAffiliationService {

}