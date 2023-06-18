package com.sai.springsecurity.sys.infra.service;

import com.sai.springsecurity.sys.infra.model.entity.SysLoginUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sai.springsecurity.sys.infra.model.entity.SysRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SAI
 * @since 2023-06-18
 */
public interface SysLoginUserService extends IService<SysLoginUser> {

    List<SysRole> getRolesByLuid(Long Luid);
}
