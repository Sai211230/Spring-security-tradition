package com.sai.springsecurity.sys.infra.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sai.springsecurity.base.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author SAI
 * @since 2023-06-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_login_user")
@ApiModel(value="SysLoginUser对象", description="")
public class SysLoginUser extends BaseEntity implements UserDetails {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "用户类型")
    @TableField("user_type")
    private Integer userType;

    @ApiModelProperty(value = "手机号码")
    @TableField("phonenumber")
    private String phonenumber;

    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "最后登录IP")
    @TableField("login_ip")
    private String loginIp;

    @ApiModelProperty(value = "最后登录时间")
    @TableField("login_date")
    private LocalDateTime loginDate;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Long userId;

    @TableField(exist = false)
    private List<SysRole> sysRoles;

    @TableField(exist = false)
    private Boolean enabled = true;

    @TableField(exist = false)
    private Boolean accountNonExpired = true;

    @TableField(exist = false)
    private Boolean accountNonLocked = true;

    @TableField(exist = false)
    private Boolean credentialsNonExpired = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysRole sysRole : sysRoles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(sysRole.getRoleName()));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
