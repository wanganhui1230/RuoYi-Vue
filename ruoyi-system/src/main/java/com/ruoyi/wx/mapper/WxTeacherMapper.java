package com.ruoyi.wx.mapper;

import java.util.List;

import com.ruoyi.wx.domain.ResWxTeacher;
import com.ruoyi.wx.domain.WxTeacher;

/**
 * 老师Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public interface WxTeacherMapper 
{
    /**
     * 查询老师
     * 
     * @param id 老师ID
     * @return 老师
     */
    public WxTeacher selectWxTeacherById(Long id);

    /**
     * 查询老师
     *
     * @param id 老师ID
     * @return 老师
     */
    public List<WxTeacher> selectWxTeacher(Long id);

    /**
     * 查询老师
     *
     * @param openId 老师ID
     * @return 老师
     */
    public WxTeacher selectWxTeacherByOpenId(String openId);

    /**
     * 查询老师列表
     * 
     * @param wxTeacher 老师
     * @return 老师集合
     */
    public List<WxTeacher> selectWxTeacherList(WxTeacher wxTeacher);

    /**
     * 查询老师列表
     *
     * @param resWxTeacher 老师
     * @return 老师集合
     */
    public List<WxTeacher> selectWxTeacherListWx(ResWxTeacher resWxTeacher);

    /**
     * 新增老师
     * 
     * @param wxTeacher 老师
     * @return 结果
     */
    public int insertWxTeacher(WxTeacher wxTeacher);

    /**
     * 修改老师
     * 
     * @param wxTeacher 老师
     * @return 结果
     */
    public int updateWxTeacher(WxTeacher wxTeacher);

    /**
     * 删除老师
     * 
     * @param id 老师ID
     * @return 结果
     */
    public int deleteWxTeacherById(Long id);

    /**
     * 批量删除老师
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxTeacherByIds(Long[] ids);
}
