package com.liobio.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liobio.common.utils.PageUtils;
import com.liobio.demo.entity.NativePlaceEntity;

import java.util.Map;

/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
public interface NativePlaceService extends IService<NativePlaceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

