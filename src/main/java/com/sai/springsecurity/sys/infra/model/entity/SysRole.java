package com.sai.springsecurity.sys.infra.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sai.springsecurity.base.model.BaseEntity;
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
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
@ApiModel(value="SysRole对象", description="")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("role_name")
    private String roleName;

    @TableField("role_key")
    private String roleKey;

    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "菜单树选择项是否关联显示")
    @TableField("menu_check_strictly")
    private Integer menuCheckStrictly;

    @ApiModelProperty(value = "部门树选择项是否关联显示")
    @TableField("dept_check_strictly")
    private Integer deptCheckStrictly;

    @ApiModelProperty(value = "角色状态（0正常 1停用）")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

}
