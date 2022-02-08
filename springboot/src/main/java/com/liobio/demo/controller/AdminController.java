package com.liobio.demo.controller;

import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.liobio.demo.entity.AdminEntity;
import com.liobio.demo.service.AdminService;
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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 保存
     */
    @PostMapping()
    public R save(@RequestBody AdminEntity admin){
        adminService.save(admin);
        return R.ok();
    }
//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = adminService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    public R info(@PathVariable("id") Integer id){
//		AdminEntity admin = adminService.getById(id);
//
//        return R.ok().put("admin", admin);
//    }
//
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody AdminEntity admin){
//		adminService.updateById(admin);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Integer[] ids){
//		adminService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}

