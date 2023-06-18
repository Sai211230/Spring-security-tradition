package com.sai.springsecurity.config.security;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sai.springsecurity.sys.infra.model.entity.SysLoginUser;
import com.sai.springsecurity.sys.infra.service.SysLoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author SAI
 * @create 2023-06-18
 */
@Component("usernameDetailsService")
public class UsernameDetailsService implements UserDetailsService {

    @Autowired
    private SysLoginUserService sysLoginUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<SysLoginUser> queryWrapper = Wrappers.lambdaQuery(SysLoginUser.class).eq(SysLoginUser::getUsername, username);
        SysLoginUser loginUser = sysLoginUserService.getOne(queryWrapper);
        if (ObjectUtil.isNotNull(loginUser)) {
            loginUser.setSysRoles(sysLoginUserService.getRolesByLuid(loginUser.getId()));
        }
        return loginUser;
    }
}
