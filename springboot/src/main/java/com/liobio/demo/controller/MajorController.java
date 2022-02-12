package com.liobio.demo.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liobio.demo.entity.MajorEntity;
import com.liobio.demo.service.MajorService;



/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
@RestController
@RequestMapping("demo/major")
public class MajorController {
    @Autowired
    private MajorService majorService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
////    @RequiresPermissions("demo:major:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = majorService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
////    @RequiresPermissions("demo:major:info")
//    public R info(@PathVariable("id") Integer id){
//		MajorEntity major = majorService.getById(id);
//
//        return R.ok().put("major", major);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
////    @RequiresPermissions("demo:major:save")
//    public R save(@RequestBody MajorEntity major){
//		majorService.save(major);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
////    @RequiresPermissions("demo:major:update")
//    public R update(@RequestBody MajorEntity major){
//		majorService.updateById(major);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
////    @RequiresPermissions("demo:major:delete")
//    public R delete(@RequestBody Integer[] ids){
//		majorService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
