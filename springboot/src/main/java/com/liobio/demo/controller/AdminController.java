package com.liobio.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.liobio.demo.common.utils.Constants;
import com.liobio.demo.common.utils.Result;
import com.liobio.demo.controller.dto.AdminDTO;
import com.liobio.demo.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.liobio.demo.entity.AdminEntity;
import com.liobio.demo.service.AdminService;


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
    @PostMapping("/admin_info")
    public Result adminSave(@RequestBody AdminEntity admin){
        adminService.save(admin);
        return Result.success();
    }
    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody AdminDTO adminDTO){
        String name = adminDTO.getName();
        String pwd = adminDTO.getPwd();
        if (StrUtil.isBlank(name) || StrUtil.isBlank(pwd)) {
            return Result.error(Constants.CODE_400, "参数错误");
        }
        return Result.success(adminService.login(adminDTO));

    }
    /**
     *  更新
     */
    @PutMapping("/admin_info")
    public Result adminUpdate(@RequestBody AdminEntity admin) {
        adminService.updateById(admin);
        return Result.success();
    }
    /**
     * 删除
     */
    @DeleteMapping("/admin_info/{id}")
    public Result adminDelete(@PathVariable Integer id) {
        adminService.deleteById(id);
        return Result.success();
    }
    /**
     * 分页查询
     */
    @GetMapping("/admin_info")
    public Result findAdminPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam(defaultValue = "") String search) {
        return Result.success(adminService.findPage(pageNum, pageSize, search));
    }



}

