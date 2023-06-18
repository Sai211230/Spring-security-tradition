package com.sai.springsecurity.sys.infra.dao;

import com.sai.springsecurity.sys.infra.model.entity.SysLoginUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sai.springsecurity.sys.infra.model.entity.SysRole;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SAI
 * @since 2023-06-18
 */
public interface SysLoginUserDao extends BaseMapper<SysLoginUser> {

    List<SysRole> getRolesByLuid(Long Luid);
}
