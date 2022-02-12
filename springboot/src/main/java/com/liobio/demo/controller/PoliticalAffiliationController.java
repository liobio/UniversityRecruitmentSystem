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

import com.liobio.demo.entity.PoliticalAffiliationEntity;
import com.liobio.demo.service.PoliticalAffiliationService;



/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
@RestController
@RequestMapping("demo/politicalaffiliation")
public class PoliticalAffiliationController {
    @Autowired
    private PoliticalAffiliationService politicalAffiliationService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
////    @RequiresPermissions("demo:politicalaffiliation:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = politicalAffiliationService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
////    @RequiresPermissions("demo:politicalaffiliation:info")
//    public R info(@PathVariable("id") Integer id){
//		PoliticalAffiliationEntity politicalAffiliation = politicalAffiliationService.getById(id);
//
//        return R.ok().put("politicalAffiliation", politicalAffiliation);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
////    @RequiresPermissions("demo:politicalaffiliation:save")
//    public R save(@RequestBody PoliticalAffiliationEntity politicalAffiliation){
//		politicalAffiliationService.save(politicalAffiliation);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
////    @RequiresPermissions("demo:politicalaffiliation:update")
//    public R update(@RequestBody PoliticalAffiliationEntity politicalAffiliation){
//		politicalAffiliationService.updateById(politicalAffiliation);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
////    @RequiresPermissions("demo:politicalaffiliation:delete")
//    public R delete(@RequestBody Integer[] ids){
//		politicalAffiliationService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
