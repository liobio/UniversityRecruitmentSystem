package com.liobio.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liobio.common.utils.PageUtils;
import com.liobio.demo.entity.PoliticalAffiliationEntity;

import java.util.Map;

/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
public interface PoliticalAffiliationService extends IService<PoliticalAffiliationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

