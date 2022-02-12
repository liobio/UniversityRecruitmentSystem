package com.liobio.demo.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.liobio.demo.service.AreaService;



/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
@RestController
@RequestMapping("demo/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
//
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = areaService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//
//    public R info(@PathVariable("id") Integer id){
//		AreaEntity area = areaService.getById(id);
//
//        return R.ok().put("area", area);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//
//    public R save(@RequestBody AreaEntity area){
//		areaService.save(area);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//
//    public R update(@RequestBody AreaEntity area){
//		areaService.updateById(area);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Integer[] ids){
//		areaService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
