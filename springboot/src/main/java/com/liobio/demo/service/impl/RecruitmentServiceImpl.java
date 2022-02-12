package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.demo.dao.RecruitmentDao;
import com.liobio.demo.entity.RecruitmentEntity;
import com.liobio.demo.service.RecruitmentService;


@Service("RecruitmentService")
public class RecruitmentServiceImpl extends ServiceImpl<RecruitmentDao, RecruitmentEntity> implements RecruitmentService {


}