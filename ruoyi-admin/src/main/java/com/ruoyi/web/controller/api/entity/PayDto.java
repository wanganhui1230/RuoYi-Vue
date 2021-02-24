package com.ruoyi.web.controller.api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PayDto {
    @ApiModelProperty("微信给的encryptedData")
    private String encryptedData;

    @ApiModelProperty("微信给的iv")
    private String iv;

    @ApiModelProperty("微信给的code")
    private String code;

}
