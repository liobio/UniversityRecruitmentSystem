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

import com.liobio.demo.entity.RecruitAndResumeEntity;
import com.liobio.demo.service.RecruitAndResumeService;
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
@RequestMapping("demo/recruitandresume")
public class RecruitAndResumeController {
    @Autowired
    private RecruitAndResumeService recruitAndResumeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("demo:recruitandresume:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = recruitAndResumeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("demo:recruitandresume:info")
    public R info(@PathVariable("id") Integer id){
		RecruitAndResumeEntity recruitAndResume = recruitAndResumeService.getById(id);

        return R.ok().put("recruitAndResume", recruitAndResume);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("demo:recruitandresume:save")
    public R save(@RequestBody RecruitAndResumeEntity recruitAndResume){
		recruitAndResumeService.save(recruitAndResume);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("demo:recruitandresume:update")
    public R update(@RequestBody RecruitAndResumeEntity recruitAndResume){
		recruitAndResumeService.updateById(recruitAndResume);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("demo:recruitandresume:delete")
    public R delete(@RequestBody Integer[] ids){
		recruitAndResumeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
