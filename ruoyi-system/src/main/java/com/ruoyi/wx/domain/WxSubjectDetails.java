package com.ruoyi.wx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科目详情对象 wx_subject_details
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public class WxSubjectDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 科目id */
    @Excel(name = "科目id")
    private Long wxSubjectDetails;

    /** 排序 */
    @Excel(name = "排序")
    private String sort;

    /** 全名 */
    @Excel(name = "全名")
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setWxSubjectDetails(Long wxSubjectDetails) 
    {
        this.wxSubjectDetails = wxSubjectDetails;
    }

    public Long getWxSubjectDetails() 
    {
        return wxSubjectDetails;
    }
    public void setSort(String sort) 
    {
        this.sort = sort;
    }

    public String getSort() 
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("wxSubjectDetails", getWxSubjectDetails())
            .append("sort", getSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
