package com.liobio.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.demo.dao.RecruitAndResumeDao;
import com.liobio.demo.entity.RecruitAndResumeEntity;
import com.liobio.demo.service.RecruitAndResumeService;


@Service("RecruitAndResumeService")
public class RecruitAndResumeServiceImpl extends ServiceImpl<RecruitAndResumeDao, RecruitAndResumeEntity> implements RecruitAndResumeService {


}