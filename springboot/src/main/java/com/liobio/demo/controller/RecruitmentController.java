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

import com.liobio.demo.entity.RecruitmentEntity;
import com.liobio.demo.service.RecruitmentService;



/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
@RestController
@RequestMapping("demo/recruitment")
public class RecruitmentController {
    @Autowired
    private RecruitmentService recruitmentService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
////    @RequiresPermissions("demo:recruitment:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = recruitmentService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
////    @RequiresPermissions("demo:recruitment:info")
//    public R info(@PathVariable("id") Integer id){
//		RecruitmentEntity recruitment = recruitmentService.getById(id);
//
//        return R.ok().put("recruitment", recruitment);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
////    @RequiresPermissions("demo:recruitment:save")
//    public R save(@RequestBody RecruitmentEntity recruitment){
//		recruitmentService.save(recruitment);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
////    @RequiresPermissions("demo:recruitment:update")
//    public R update(@RequestBody RecruitmentEntity recruitment){
//		recruitmentService.updateById(recruitment);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
////    @RequiresPermissions("demo:recruitment:delete")
//    public R delete(@RequestBody Integer[] ids){
//		recruitmentService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
