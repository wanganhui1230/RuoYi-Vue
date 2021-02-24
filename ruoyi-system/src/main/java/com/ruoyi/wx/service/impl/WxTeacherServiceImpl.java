package com.ruoyi.wx.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.wx.domain.ResWxTeacher;
import com.ruoyi.wx.service.IWxTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wx.mapper.WxTeacherMapper;
import com.ruoyi.wx.domain.WxTeacher;

/**
 * 老师Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
@Service
public class WxTeacherServiceImpl implements IWxTeacherService
{
    @Autowired
    private WxTeacherMapper wxTeacherMapper;

    /**
     * 查询老师
     * 
     * @param id 老师ID
     * @return 老师
     */
    @Override
    public WxTeacher selectWxTeacherById(Long id)
    {
        return wxTeacherMapper.selectWxTeacherById(id);
    }

    /**
     * 查询老师列表
     * 
     * @param wxTeacher 老师
     * @return 老师
     */
    @Override
    public List<WxTeacher> selectWxTeacherList(WxTeacher wxTeacher)
    {
        return wxTeacherMapper.selectWxTeacherList(wxTeacher);
    }

    /**
     * 查询老师列表
     *
     * @param resWxTeacher 老师
     * @return 老师
     */
    @Override
    public List<WxTeacher> selectWxTeacherList(ResWxTeacher resWxTeacher)
    {
        return wxTeacherMapper.selectWxTeacherListWx(resWxTeacher);
    }

    /**
     * 新增老师
     * 
     * @param wxTeacher 老师
     * @return 结果
     */
    @Override
    public int insertWxTeacher(WxTeacher wxTeacher)
    {
        wxTeacher.setCreateTime(DateUtils.getNowDate());
        return wxTeacherMapper.insertWxTeacher(wxTeacher);
    }

    /**
     * 修改老师
     * 
     * @param wxTeacher 老师
     * @return 结果
     */
    @Override
    public int updateWxTeacher(WxTeacher wxTeacher)
    {
        wxTeacher.setUpdateTime(DateUtils.getNowDate());
        return wxTeacherMapper.updateWxTeacher(wxTeacher);
    }

    /**
     * 批量删除老师
     * 
     * @param ids 需要删除的老师ID
     * @return 结果
     */
    @Override
    public int deleteWxTeacherByIds(Long[] ids)
    {
        return wxTeacherMapper.deleteWxTeacherByIds(ids);
    }

    /**
     * 删除老师信息
     * 
     * @param id 老师ID
     * @return 结果
     */
    @Override
    public int deleteWxTeacherById(Long id)
    {
        return wxTeacherMapper.deleteWxTeacherById(id);
    }
}
