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
@TableName("t_employer")
public class EmployerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String pwd;
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
	private Integer companyId;
	/**
	 * 所在地区
	 */
	private Integer area;
	/**
	 * 
	 */
	private Date registerTime;
	/**
	 * 
	 */
	private String state;

}
