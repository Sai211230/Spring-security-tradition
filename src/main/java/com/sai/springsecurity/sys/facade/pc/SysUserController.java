package com.sai.springsecurity.sys.facade.pc;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sai.springsecurity.sys.infra.model.entity.SysUser;
import com.sai.springsecurity.sys.infra.model.query.SysUserQuery;
import com.sai.springsecurity.sys.infra.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author SAI
 * @create 2023-06-14
 */

@Api("用户信息")
@RequestMapping("/sys/user")
@RestController
@RequiredArgsConstructor
public class SysUserController {

    private final SysUserService sysUserService;

    @ApiOperation("获取所有用户信息")
    @PostMapping("/getAll")
    public List<SysUser> getAllUsers() {
        return sysUserService.list();
    }

    @ApiOperation("获取分页用户信息")
    @PostMapping("/getPage")
    public Page<SysUser> getUserPage(SysUserQuery query) {
        Page<SysUser> page = new Page<>(query.getCurrent(), query.getSize());
        LambdaQueryWrapper<SysUser> queryWrapper = Wrappers.lambdaQuery(SysUser.class)
                .like(SysUser::getUsername, query.getUsername())
                .orderByDesc(SysUser::getCreateTime);
        return sysUserService.page(page, queryWrapper);
    }
}
