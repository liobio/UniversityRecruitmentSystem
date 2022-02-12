package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.demo.dao.AreaDao;
import com.liobio.demo.entity.AreaEntity;
import com.liobio.demo.service.AreaService;


@Service("AreaService")
public class AreaServiceImpl extends ServiceImpl<AreaDao, AreaEntity> implements AreaService {

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<AreaEntity> page = this.page(
//                new Query<AreaEntity>().getPage(params),
//                new QueryWrapper<AreaEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}