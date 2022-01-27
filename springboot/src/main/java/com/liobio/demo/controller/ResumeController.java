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

import com.liobio.demo.entity.ResumeEntity;
import com.liobio.demo.service.ResumeService;
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
@RequestMapping("demo/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("demo:resume:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = resumeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("demo:resume:info")
    public R info(@PathVariable("id") Integer id){
		ResumeEntity resume = resumeService.getById(id);

        return R.ok().put("resume", resume);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("demo:resume:save")
    public R save(@RequestBody ResumeEntity resume){
		resumeService.save(resume);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("demo:resume:update")
    public R update(@RequestBody ResumeEntity resume){
		resumeService.updateById(resume);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("demo:resume:delete")
    public R delete(@RequestBody Integer[] ids){
		resumeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
