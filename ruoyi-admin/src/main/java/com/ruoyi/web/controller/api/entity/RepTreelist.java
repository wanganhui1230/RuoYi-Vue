package com.ruoyi.web.controller.api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class RepTreelist {

    @ApiModelProperty("科目id")
    private String id;

    @ApiModelProperty("科目名称")
    private String label;

    @ApiModelProperty("学科详情")
    private List<Treelist> children;

}
