package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.liobio.demo.dao.ResumeDao;
import com.liobio.demo.entity.ResumeEntity;
import com.liobio.demo.service.ResumeService;


@Service("ResumeService")
public class ResumeServiceImpl extends ServiceImpl<ResumeDao, ResumeEntity> implements ResumeService {

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<ResumeEntity> page = this.page(
//                new Query<ResumeEntity>().getPage(params),
//                new QueryWrapper<ResumeEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}