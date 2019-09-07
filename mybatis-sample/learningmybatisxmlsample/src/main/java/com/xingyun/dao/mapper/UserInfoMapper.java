package com.xingyun.dao.mapper;

import com.xingyun.model.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * 功能: 用户信息MyBatis接口层
 * 作者: 星云
 * 时间: 2019/8/29 11:03
 */
public interface UserInfoMapper {

    int insertUserInfo(UserInfo userInfo);

    int deleteUserInfoByUserInfoId(Long userInfoId);

    int updateUserInfo(UserInfo userInfo);

    UserInfo selectUserInfoByUserInfoId(Long userInfoId);

    List<UserInfo> selectAllUserInfo();

    List<UserInfo> selectAllUserInfoByCondition(Map<String, Object> queryMap);
}
