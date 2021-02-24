package com.ruoyi.web.controller.api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RepArea {

    @ApiModelProperty("区域id")
    private String id;

    @ApiModelProperty("区域名称")
    private String name;


}
