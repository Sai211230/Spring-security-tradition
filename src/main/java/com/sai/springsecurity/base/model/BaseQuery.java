package com.sai.springsecurity.base.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author SAI
 * @create 2023-06-14
 */
@ApiModel("基础查询父类")
@Data
public class BaseQuery implements Serializable {

    @ApiModelProperty("当前页")
    private Integer current = 1;

    @ApiModelProperty("每页数量")
    private Integer size = 20;
}
