package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.demo.dao.NationalDao;
import com.liobio.demo.entity.NationalEntity;
import com.liobio.demo.service.NationalService;


@Service("NationalService")
public class NationalServiceImpl extends ServiceImpl<NationalDao, NationalEntity> implements NationalService {



}