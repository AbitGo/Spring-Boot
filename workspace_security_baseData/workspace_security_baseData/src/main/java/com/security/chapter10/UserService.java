package com.security.chapter10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public UserDetails loadUserByUserName(String username)throws UsernameNotFoundException{
        User user = userMapper.loadUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("账户不存在");
        }
        user.setRoles(userMapper.getUsersRolesByUid(user.getId()));
        return user;
    }

}
