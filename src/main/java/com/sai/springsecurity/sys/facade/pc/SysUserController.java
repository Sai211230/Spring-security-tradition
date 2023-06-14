package com.sai.springsecurity.sys.facade.pc;

import com.sai.springsecurity.sys.infra.model.entity.SysUser;
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
    public List<SysUser> getUserList() {
        return sysUserService.list();
    }
}
