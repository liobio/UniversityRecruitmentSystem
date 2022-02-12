package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.liobio.demo.dao.JobDao;
import com.liobio.demo.entity.JobEntity;
import com.liobio.demo.service.JobService;


@Service("JobService")
public class JobServiceImpl extends ServiceImpl<JobDao, JobEntity> implements JobService {



}