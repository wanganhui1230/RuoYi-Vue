package com.ruoyi.wx.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 老师对象 wx_teacher
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public class WxTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    @ApiModelProperty("主键id")
    private Long id;

    /** 老师名称 */
    @ApiModelProperty("老师名称")
    @Excel(name = "老师名称")
    private String name;

    /** 科目id */
    @ApiModelProperty("科目id")
    @Excel(name = "科目id")
    private String subject;

    /** 区域id */
    @ApiModelProperty("区域id")
    @Excel(name = "区域id")
    private String area;

    /** 科目 */
    @ApiModelProperty("科目")
    @Excel(name = "科目")
    private String subjectName;

    /** 区域 */
    @ApiModelProperty("区域")
    @Excel(name = "区域")
    private String areaName;

    /** 高考分数 */
    @ApiModelProperty("高考分数")
    @Excel(name = "高考分数")
    private String fraction;

    /** 院校 */
    @ApiModelProperty("院校")
    @Excel(name = "院校")
    private String colleges;

    /** 最近登录时间 */
    @ApiModelProperty("最近登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loginTime;

    /** 头像 */
    @ApiModelProperty("头像")
    @Excel(name = "头像")
    private String image;

    /** 编号id */
    @ApiModelProperty("编号id")
    @Excel(name = "编号id")
    private String numberId;

    /** 微信id */
    @ApiModelProperty("微信id")
    @Excel(name = "微信id")
    private String openId;

    /** 性别 */
    @ApiModelProperty("性别")
    @Excel(name = "性别")
    private String sex;

    /** 目前身份 */
    @ApiModelProperty("目前身份")
    @Excel(name = "目前身份")
    private String identity;

    /** 手机号 */
    @ApiModelProperty("手机号")
    @Excel(name = "手机号")
    private String phone;

    /** 微信号 */
    @ApiModelProperty("区域")
    @Excel(name = "微信号")
    private String wechat;

    /** qq号 */
    @ApiModelProperty("qq号")
    @Excel(name = "qq号")
    private String qq;

    /** 身份证正 */
    @ApiModelProperty("身份证正")
    @Excel(name = "身份证正")
    private String cardZ;

    /** 身份证反 */
    @ApiModelProperty("身份证反")
    @Excel(name = "身份证反")
    private String cardF;

    /** 学生证/毕业证 */
    @ApiModelProperty("学生证/毕业证")
    @Excel(name = "学生证/毕业证")
    private String studentCard;

    /** 身份证号 */
    @ApiModelProperty("身份证号")
    @Excel(name = "身份证号")
    private String cardH;

    /** 认证状态 */
    @ApiModelProperty("认证状态")
    @Excel(name = "认证状态")
    private String status;

    /** 热度 */
    @ApiModelProperty("热度")
    @Excel(name = "热度")
    private String heat;

    /** 视频 */
    @ApiModelProperty("视频")
    private String spare1;

    /** 老师类型 */
    @ApiModelProperty("老师类型")
    private String spare2;

    /** 老师级别 */
    @ApiModelProperty("老师级别")
    private String spare3;

    /** 备用4 */
    @ApiModelProperty("备用4")
    private String spare4;

    /** 备用5 */
    @ApiModelProperty("备用5")
    private String spare5;

    /** 备用6 */
    @ApiModelProperty("备用6")
    private String spare6;

    /** 备用7 */
    @ApiModelProperty("备用7")
    private String spare7;

    /** 备用8 */
    @ApiModelProperty("备用8")
    private String spare8;

    /** 备用9 */
    @ApiModelProperty("备用9")
    private String spare9;

    /** 备用10 */
    @ApiModelProperty("备用10")
    private String spare10;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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
    public void setSubject(String subject) 
    {
        this.subject = subject;
    }

    public String getSubject() 
    {
        return subject;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setFraction(String fraction) 
    {
        this.fraction = fraction;
    }

    public String getFraction() 
    {
        return fraction;
    }
    public void setColleges(String colleges) 
    {
        this.colleges = colleges;
    }

    public String getColleges() 
    {
        return colleges;
    }
    public void setLoginTime(Date loginTime) 
    {
        this.loginTime = loginTime;
    }

    public Date getLoginTime() 
    {
        return loginTime;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setNumberId(String numberId) 
    {
        this.numberId = numberId;
    }

    public String getNumberId() 
    {
        return numberId;
    }
    public void setOpenId(String openId)
    {
        this.openId = openId;
    }

    public String getOpenId()
    {
        return openId;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setIdentity(String identity) 
    {
        this.identity = identity;
    }

    public String getIdentity() 
    {
        return identity;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setWechat(String wechat) 
    {
        this.wechat = wechat;
    }

    public String getWechat() 
    {
        return wechat;
    }
    public void setQq(String qq) 
    {
        this.qq = qq;
    }

    public String getQq() 
    {
        return qq;
    }
    public void setCardZ(String cardZ) 
    {
        this.cardZ = cardZ;
    }

    public String getCardZ() 
    {
        return cardZ;
    }
    public void setCardF(String cardF) 
    {
        this.cardF = cardF;
    }

    public String getCardF() 
    {
        return cardF;
    }
    public void setStudentCard(String studentCard) 
    {
        this.studentCard = studentCard;
    }

    public String getStudentCard() 
    {
        return studentCard;
    }
    public void setCardH(String cardH) 
    {
        this.cardH = cardH;
    }

    public String getCardH() 
    {
        return cardH;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setHeat(String heat) 
    {
        this.heat = heat;
    }

    public String getHeat() 
    {
        return heat;
    }
    public void setSpare1(String spare1) 
    {
        this.spare1 = spare1;
    }

    public String getSpare1() 
    {
        return spare1;
    }
    public void setSpare2(String spare2) 
    {
        this.spare2 = spare2;
    }

    public String getSpare2() 
    {
        return spare2;
    }
    public void setSpare3(String spare3) 
    {
        this.spare3 = spare3;
    }

    public String getSpare3() 
    {
        return spare3;
    }
    public void setSpare4(String spare4) 
    {
        this.spare4 = spare4;
    }

    public String getSpare4() 
    {
        return spare4;
    }
    public void setSpare5(String spare5) 
    {
        this.spare5 = spare5;
    }

    public String getSpare5() 
    {
        return spare5;
    }
    public void setSpare6(String spare6) 
    {
        this.spare6 = spare6;
    }

    public String getSpare6() 
    {
        return spare6;
    }
    public void setSpare7(String spare7) 
    {
        this.spare7 = spare7;
    }

    public String getSpare7() 
    {
        return spare7;
    }
    public void setSpare8(String spare8) 
    {
        this.spare8 = spare8;
    }

    public String getSpare8() 
    {
        return spare8;
    }
    public void setSpare9(String spare9) 
    {
        this.spare9 = spare9;
    }

    public String getSpare9() 
    {
        return spare9;
    }
    public void setSpare10(String spare10) 
    {
        this.spare10 = spare10;
    }

    public String getSpare10() 
    {
        return spare10;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("subject", getSubject())
            .append("area", getArea())
            .append("fraction", getFraction())
            .append("colleges", getColleges())
            .append("loginTime", getLoginTime())
            .append("image", getImage())
            .append("numberId", getNumberId())
            .append("openId", getOpenId())
            .append("sex", getSex())
            .append("identity", getIdentity())
            .append("phone", getPhone())
            .append("wechat", getWechat())
            .append("qq", getQq())
            .append("cardZ", getCardZ())
            .append("cardF", getCardF())
            .append("studentCard", getStudentCard())
            .append("cardH", getCardH())
            .append("status", getStatus())
            .append("heat", getHeat())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("spare1", getSpare1())
            .append("spare2", getSpare2())
            .append("spare3", getSpare3())
            .append("spare4", getSpare4())
            .append("spare5", getSpare5())
            .append("spare6", getSpare6())
            .append("spare7", getSpare7())
            .append("spare8", getSpare8())
            .append("spare9", getSpare9())
            .append("spare10", getSpare10())
            .toString();
    }
}
