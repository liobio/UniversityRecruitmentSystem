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

import com.liobio.demo.entity.EmployerEntity;
import com.liobio.demo.service.EmployerService;
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
@RequestMapping("demo/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    @RequiresPermissions("demo:employer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = employerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("demo:employer:info")
    public R info(@PathVariable("id") Integer id){
		EmployerEntity employer = employerService.getById(id);

        return R.ok().put("employer", employer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("demo:employer:save")
    public R save(@RequestBody EmployerEntity employer){
		employerService.save(employer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("demo:employer:update")
    public R update(@RequestBody EmployerEntity employer){
		employerService.updateById(employer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("demo:employer:delete")
    public R delete(@RequestBody Integer[] ids){
		employerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
