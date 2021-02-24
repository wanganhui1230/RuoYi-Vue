package com.ruoyi.wx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 备选老师对象 wx_alternative
 * 
 * @author w
 * @date 2021-02-24
 */
public class WxAlternative extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 学员id */
    @Excel(name = "学员id")
    private Long trainee;

    /** 老师id */
    @Excel(name = "老师id")
    private Long teacherId;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTrainee(Long trainee) 
    {
        this.trainee = trainee;
    }

    public Long getTrainee() 
    {
        return trainee;
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
            .append("id", getId())
            .append("trainee", getTrainee())
            .append("teacherId", getTeacherId())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
