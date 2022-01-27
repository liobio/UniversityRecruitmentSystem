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

import com.liobio.demo.entity.DegreeEntity;
import com.liobio.demo.service.DegreeService;
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
@RequestMapping("demo/degree")
public class DegreeController {
    @Autowired
    private DegreeService degreeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("demo:degree:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = degreeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("demo:degree:info")
    public R info(@PathVariable("id") Integer id){
		DegreeEntity degree = degreeService.getById(id);

        return R.ok().put("degree", degree);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("demo:degree:save")
    public R save(@RequestBody DegreeEntity degree){
		degreeService.save(degree);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("demo:degree:update")
    public R update(@RequestBody DegreeEntity degree){
		degreeService.updateById(degree);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("demo:degree:delete")
    public R delete(@RequestBody Integer[] ids){
		degreeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
