package com.sai.springsecurity.sys.infra.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import com.sai.springsecurity.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author SAI
 * @since 2023-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "用户信息表")
public class SysUser extends BaseEntity {

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty(value = "部门ID")
    @TableField("dept_id")
    private Long deptId;

    @ApiModelProperty(value = "用户账号")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "用户昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value = "用户类型（00系统用户）")
    @TableField("user_type")
    private String userType;

    @ApiModelProperty(value = "用户邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "手机号码")
    @TableField("phonenumber")
    private String phonenumber;

    @ApiModelProperty(value = "用户性别（0男 1女 2未知）")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "头像地址")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "最后登录IP")
    @TableField("login_ip")
    private String loginIp;

    @ApiModelProperty(value = "最后登录时间")
    @TableField("login_date")
    private LocalDateTime loginDate;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

}
