package com.ruoyi.web.controller.api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RepWx {

    @ApiModelProperty("微信id")
    private String openId;

    @ApiModelProperty("手机号")
    private String phoneNumber;
}
