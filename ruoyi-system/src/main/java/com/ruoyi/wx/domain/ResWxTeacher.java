package com.ruoyi.wx.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * 老师对象 wx_teacher
 *
 * @author ruoyi
 * @date 2021-02-23
 */
@Data
public class ResWxTeacher
{

    /** 科目 */
    @ApiModelProperty("科目id")
    private String subject;

    /** 区域 */
    @ApiModelProperty("区域id")
    private String area;


    /** 编号 */
    @ApiModelProperty("编号")
    private String numberId;

    /** 性别 */
    @ApiModelProperty("性别")
    private Long sex;

    /** 老师类型 */
    @ApiModelProperty("老师类型")
    private String spare2;

    /** 老师级别 */
    @ApiModelProperty("老师级别")
    private String spare3;

    /** 分页 */
    @ApiModelProperty("第几页")
    private Integer pageNum;

    /** 分页 */
    @ApiModelProperty("多少条")
    private Integer pageSize;

}
