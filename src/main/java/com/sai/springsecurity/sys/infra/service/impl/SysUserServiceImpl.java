package com.sai.springsecurity.sys.infra.service.impl;

import com.sai.springsecurity.sys.infra.model.entity.SysUser;
import com.sai.springsecurity.sys.infra.dao.SysUserDao;
import com.sai.springsecurity.sys.infra.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author SAI
 * @since 2023-06-14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

}
