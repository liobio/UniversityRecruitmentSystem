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
@TableName("t_recruitment")
public class RecruitmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String jobId;
	/**
	 * 工作地区
	 */
	private Integer areaId;
	/**
	 * 招聘人数
	 */
	private String recruitingNumber;
	/**
	 * 薪水
	 */
	private String salary;
	/**
	 * 职位信息
	 */
	private String jobInfo;
	/**
	 * 专业要求
	 */
	private Integer majorId;
	/**
	 * 学历要求
	 */
	private Integer degreeId;
	/**
	 * 性别要求;0-男;1-女;2-不限
	 */
	private Integer sex;
	/**
	 * 人事管理人employer
	 */
	private Integer hrId;
	/**
	 * 
	 */
	private String tel;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private Date time;

}
