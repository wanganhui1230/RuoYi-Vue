package com.ruoyi.wx.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 备选老师对象 wx_alternative
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
public class WxAlternative
{
    private static final long serialVersionUID = 1L;

    /** 学员id */
    @ApiModelProperty("学员id")
    private Long traineeId;

    /** 老师id */
    @ApiModelProperty("老师id")
    private Long teacherId;

    /** 状态 */
    @Excel(name = "状态")
    @ApiModelProperty("状态 1备选  2确认")
    private String status;

    /** 创建时间 */
    @ApiModelProperty(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setTraineeId(Long traineeId)
    {
        this.traineeId = traineeId;
    }

    public Long getTraineeId() 
    {
        return traineeId;
    }
    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("traineeId", getTraineeId())
            .append("teacherId", getTeacherId())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
