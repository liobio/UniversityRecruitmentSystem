package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.liobio.demo.dao.EmployerDao;
import com.liobio.demo.entity.EmployerEntity;
import com.liobio.demo.service.EmployerService;


@Service("EmployerService")
public class EmployerServiceImpl extends ServiceImpl<EmployerDao, EmployerEntity> implements EmployerService {



}