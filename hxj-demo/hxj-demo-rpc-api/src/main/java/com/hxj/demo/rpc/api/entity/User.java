package com.hxj.demo.rpc.api.entity;


import javax.persistence.Column;

import com.hxj.common.api.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User extends BaseEntity{
	
	private static final long serialVersionUID = 5927571857089092391L;
    
	@Column(name = "user_name")
	private String userName; //用户名
    
	@Column(name = "user_password")
	private String userPassword; //密码
    
	@Column(name = "user_phone")
	private String userPhone; //手机
    
	@Column(name = "user_email")
	private String userEmail; //邮箱
    
	@Column(name = "user_info")
	private String userInfo; //简介
    
	@Column(name = "head_image")
	private String headImage; //头像地址
    
	@Column(name = "status")
	private Integer status; //状态，0不可用，1可用，默认为1
}
