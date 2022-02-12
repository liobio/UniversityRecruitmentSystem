package com.liobio.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liobio.demo.entity.AdminEntity;
import com.liobio.demo.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
	@Autowired
	AdminService adminService;
	@Test
	void contextLoads() {
		 Page<AdminEntity> test=adminService.findPage(1,3,"");

		//通过page对象获取分页数据
		System.out.println(test.getCurrent());//当前页
		System.out.println(test.getRecords());//每页数据list集合
		System.out.println(test.getSize());//每页显示记录数
		System.out.println(test.getTotal()); //总记录数
		System.out.println(test.getPages()); //总页数


	}

}
