package com.ruoyi.web.controller.api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Treelist {

    @ApiModelProperty("学科id")
    private String id;

    @ApiModelProperty("学科名称")
    private String label;


}
