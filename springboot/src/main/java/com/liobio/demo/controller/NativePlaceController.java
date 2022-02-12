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

import com.liobio.demo.entity.NativePlaceEntity;
import com.liobio.demo.service.NativePlaceService;


/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
@RestController
@RequestMapping("demo/nativeplace")
public class NativePlaceController {
    @Autowired
    private NativePlaceService nativePlaceService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
////    @RequiresPermissions("demo:nativeplace:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = nativePlaceService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
////    @RequiresPermissions("demo:nativeplace:info")
//    public R info(@PathVariable("id") Integer id){
//		NativePlaceEntity nativePlace = nativePlaceService.getById(id);
//
//        return R.ok().put("nativePlace", nativePlace);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
////    @RequiresPermissions("demo:nativeplace:save")
//    public R save(@RequestBody NativePlaceEntity nativePlace){
//		nativePlaceService.save(nativePlace);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
////    @RequiresPermissions("demo:nativeplace:update")
//    public R update(@RequestBody NativePlaceEntity nativePlace){
//		nativePlaceService.updateById(nativePlace);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
////    @RequiresPermissions("demo:nativeplace:delete")
//    public R delete(@RequestBody Integer[] ids){
//		nativePlaceService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
