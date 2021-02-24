package com.ruoyi.web.controller.api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RepUser {

    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("用户类型  1老师 2学员")
    private Integer type;

    @ApiModelProperty("是否登录 false否  true是")
    private boolean status = false;
}
