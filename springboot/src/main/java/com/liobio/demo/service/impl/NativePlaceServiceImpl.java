package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.common.utils.PageUtils;
import com.liobio.common.utils.Query;

import com.liobio.demo.dao.NativePlaceDao;
import com.liobio.demo.entity.NativePlaceEntity;
import com.liobio.demo.service.NativePlaceService;


@Service("nativePlaceService")
public class NativePlaceServiceImpl extends ServiceImpl<NativePlaceDao, NativePlaceEntity> implements NativePlaceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NativePlaceEntity> page = this.page(
                new Query<NativePlaceEntity>().getPage(params),
                new QueryWrapper<NativePlaceEntity>()
        );

        return new PageUtils(page);
    }

}