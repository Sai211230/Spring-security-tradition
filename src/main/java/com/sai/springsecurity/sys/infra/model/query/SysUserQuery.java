package com.sai.springsecurity.sys.infra.model.query;

import com.sai.springsecurity.base.model.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author SAI
 * @create 2023-06-14
 */
@ApiModel("用户查询对象")
@Data
public class SysUserQuery extends BaseQuery {

    private String username;
}
