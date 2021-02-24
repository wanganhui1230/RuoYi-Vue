package com.ruoyi.web.controller.api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RepUpload {

    @ApiModelProperty("文件名称")
    private String fileName;

    @ApiModelProperty("文件路径")
    private String url;


}
