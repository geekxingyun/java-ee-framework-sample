package com.xingyun.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 功能: 用户信息实体类
 * 作者: 星云
 * 时间: 2019/8/29 10:58
 */
@Getter
@Setter
@ToString
//@Alias("UserInfo")
public class UserInfo {
    //用户信息ID
    private Long userInfoId;
    //用户信息名称
    private String userInfoName;
    //用户信息手机号
    private String userInfoMobile;
    //用户信息年龄
    private Integer userInfoAge;
    //用户信息性别
    private Boolean userInfoSex;
}
