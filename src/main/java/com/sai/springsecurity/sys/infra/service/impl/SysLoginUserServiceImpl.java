package com.sai.springsecurity.sys.infra.service.impl;

import com.sai.springsecurity.sys.infra.model.entity.SysLoginUser;
import com.sai.springsecurity.sys.infra.dao.SysLoginUserDao;
import com.sai.springsecurity.sys.infra.model.entity.SysRole;
import com.sai.springsecurity.sys.infra.service.SysLoginUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SAI
 * @since 2023-06-18
 */
@Service
public class SysLoginUserServiceImpl extends ServiceImpl<SysLoginUserDao, SysLoginUser> implements SysLoginUserService {

    @Override
    public List<SysRole> getRolesByLuid(Long Luid) {
        return baseMapper.getRolesByLuid(Luid);
    }

}
