package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.liobio.demo.dao.DegreeDao;
import com.liobio.demo.entity.DegreeEntity;
import com.liobio.demo.service.DegreeService;


@Service("DegreeService")
public class DegreeServiceImpl extends ServiceImpl<DegreeDao, DegreeEntity> implements DegreeService {


}