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

import com.liobio.demo.entity.NationalEntity;
import com.liobio.demo.service.NationalService;
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
@RequestMapping("demo/national")
public class NationalController {
    @Autowired
    private NationalService nationalService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("demo:national:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nationalService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("demo:national:info")
    public R info(@PathVariable("id") Integer id){
		NationalEntity national = nationalService.getById(id);

        return R.ok().put("national", national);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("demo:national:save")
    public R save(@RequestBody NationalEntity national){
		nationalService.save(national);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("demo:national:update")
    public R update(@RequestBody NationalEntity national){
		nationalService.updateById(national);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("demo:national:delete")
    public R delete(@RequestBody Integer[] ids){
		nationalService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
