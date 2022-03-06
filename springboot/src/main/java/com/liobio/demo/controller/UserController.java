package com.liobio.demo.controller;

import java.util.Arrays;
import java.util.Map;

import com.liobio.demo.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.liobio.demo.entity.UserEntity;
import com.liobio.demo.service.UserService;



/**
 * 
 *
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 保存
     */
    @PostMapping("/user_info")
    public Result userSave(@RequestBody UserEntity user){
        userService.save(user);
        return Result.success();
    }
    /**
     *  更新
     */
    @PutMapping("/user_info")
    public Result userUpdate(@RequestBody UserEntity user) {
        userService.updateById(user);
        return Result.success();
    }
    /**
     * 删除
     */
    @DeleteMapping("/user_info/{id}")
    public Result userDelete(@PathVariable Integer id) {
        userService.deleteById(id);
        return Result.success();
    }
    /**
     * 分页查询
     */
    @GetMapping("/user_info")
    public Result findUserPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "20") Integer pageSize,
                                   @RequestParam(defaultValue = "") String search) {
        return Result.success(userService.findPage(pageNum, pageSize, search));
    }
    /**
     * 列表
     */
//    @RequestMapping("/list")
////    @RequiresPermissions("demo:user:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = userService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
////    @RequiresPermissions("demo:user:info")
//    public R info(@PathVariable("id") Integer id){
//		UserEntity user = userService.getById(id);
//
//        return R.ok().put("user", user);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
////    @RequiresPermissions("demo:user:save")
//    public R save(@RequestBody UserEntity user){
//		userService.save(user);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
////    @RequiresPermissions("demo:user:update")
//    public R update(@RequestBody UserEntity user){
//		userService.updateById(user);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
////    @RequiresPermissions("demo:user:delete")
//    public R delete(@RequestBody Integer[] ids){
//		userService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
