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

import com.liobio.demo.entity.NoticeEntity;
import com.liobio.demo.service.NoticeService;
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
@RequestMapping("demo/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("demo:notice:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = noticeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("demo:notice:info")
    public R info(@PathVariable("id") Integer id){
		NoticeEntity notice = noticeService.getById(id);

        return R.ok().put("notice", notice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("demo:notice:save")
    public R save(@RequestBody NoticeEntity notice){
		noticeService.save(notice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("demo:notice:update")
    public R update(@RequestBody NoticeEntity notice){
		noticeService.updateById(notice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("demo:notice:delete")
    public R delete(@RequestBody Integer[] ids){
		noticeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
