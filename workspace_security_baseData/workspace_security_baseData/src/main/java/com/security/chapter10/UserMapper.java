package com.security.chapter10;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User loadUserByUserName(String username);
    List<Role> getUsersRolesByUid(Integer id);
}
