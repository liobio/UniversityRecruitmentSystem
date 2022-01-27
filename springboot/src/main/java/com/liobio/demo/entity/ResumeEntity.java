package com.liobio.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
@Data
@TableName("t_resume")
public class ResumeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Integer sex;
	/**
	 * 出生年月
	 */
	private Date birthday;
	/**
	 * 籍贯
	 */
	private Integer nativePlace;
	/**
	 * 民族
	 */
	private Integer national;
	/**
	 * 政治面貌
	 */
	private Integer politicalAffiliation;
	/**
	 * 现居地
	 */
	private Integer presentArea;
	/**
	 * 
	 */
	private String tel;
	/**
	 * 
	 */
	private String email;
	/**
	 * 毕业高校
	 */
	private Integer graduatedUniversity;
	/**
	 * 主修专业
	 */
	private Integer major;
	/**
	 * 学历
	 */
	private Integer degree;
	/**
	 * 个人介绍
	 */
	private String personalIntroduction;
	/**
	 * 期望薪水
	 */
	private String expectedSalary;
	/**
	 * 求职岗位
	 */
	private Integer expectedJob;
	/**
	 * 求职地区
	 */
	private Integer expectedArea;
	/**
	 * 项目经验
	 */
	private String projectExperience;
	/**
	 * 
	 */
	private String state;

}
