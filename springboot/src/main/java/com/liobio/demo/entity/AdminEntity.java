package com.liobio.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 
 * @author liobio
 * @email liobio1999@163.com
 * @date 2022-01-27 23:20:58
 */
@Data
@TableName("t_admin")
public class AdminEntity implements Serializable {
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
	private Integer level;
	/**
	 * 
	 */
	private String avatarUrl;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registerTime;
	/**
	 * 
	 */
	private Integer state;

}
