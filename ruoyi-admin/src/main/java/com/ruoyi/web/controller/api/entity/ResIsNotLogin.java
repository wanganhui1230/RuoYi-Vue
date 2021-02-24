package com.ruoyi.web.controller.api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResIsNotLogin {

    @ApiModelProperty("微信id")
    private String openId;
}
