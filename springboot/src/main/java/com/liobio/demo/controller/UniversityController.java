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

import com.liobio.demo.entity.UniversityEntity;
import com.liobio.demo.service.UniversityService;
import com.liobio.common.utils.PageUtils;
import com.liobio.common.utils.R;



/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
@RestController
@RequestMapping("demo/university")
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("demo:university:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = universityService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("demo:university:info")
    public R info(@PathVariable("id") Integer id){
		UniversityEntity university = universityService.getById(id);

        return R.ok().put("university", university);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("demo:university:save")
    public R save(@RequestBody UniversityEntity university){
		universityService.save(university);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("demo:university:update")
    public R update(@RequestBody UniversityEntity university){
		universityService.updateById(university);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("demo:university:delete")
    public R delete(@RequestBody Integer[] ids){
		universityService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
