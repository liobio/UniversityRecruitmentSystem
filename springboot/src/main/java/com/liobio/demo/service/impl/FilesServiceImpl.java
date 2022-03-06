package com.liobio.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liobio.demo.dao.AreaDao;
import com.liobio.demo.dao.FilesDao;
import com.liobio.demo.entity.AreaEntity;
import com.liobio.demo.entity.FilesEntity;
import com.liobio.demo.service.AreaService;
import com.liobio.demo.service.FilesService;
import org.springframework.stereotype.Service;


@Service("FilesService")
public class FilesServiceImpl extends ServiceImpl<FilesDao, FilesEntity> implements FilesService {



}