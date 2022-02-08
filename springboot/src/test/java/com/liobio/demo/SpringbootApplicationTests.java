package com.liobio.demo;

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
		AdminEntity adminEntity = new AdminEntity();
		adminEntity.setName("level_2");
		adminEntity.setLevel(2);
		adminService.save(adminEntity);

	}

}
