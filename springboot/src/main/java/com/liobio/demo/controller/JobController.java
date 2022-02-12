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

import com.liobio.demo.entity.JobEntity;
import com.liobio.demo.service.JobService;



/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
@RestController
@RequestMapping("demo/job")
public class JobController {
    @Autowired
    private JobService jobService;
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
////    @RequiresPermissions("demo:job:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = jobService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
////    @RequiresPermissions("demo:job:info")
//    public R info(@PathVariable("id") Integer id){
//		JobEntity job = jobService.getById(id);
//
//        return R.ok().put("job", job);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
////    @RequiresPermissions("demo:job:save")
//    public R save(@RequestBody JobEntity job){
//		jobService.save(job);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
////    @RequiresPermissions("demo:job:update")
//    public R update(@RequestBody JobEntity job){
//		jobService.updateById(job);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
////    @RequiresPermissions("demo:job:delete")
//    public R delete(@RequestBody Integer[] ids){
//		jobService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
