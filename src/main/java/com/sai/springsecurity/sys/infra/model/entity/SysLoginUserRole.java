package com.sai.springsecurity.sys.infra.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author SAI
 * @since 2023-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_login_user_role")
@ApiModel(value="SysLoginUserRole对象", description="")
public class SysLoginUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "登录用户id")
    @TableField("login_user_id")
    private Long loginUserId;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private Long roleId;


}
