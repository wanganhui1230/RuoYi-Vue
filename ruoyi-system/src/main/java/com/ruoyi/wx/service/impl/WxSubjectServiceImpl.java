package com.ruoyi.wx.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wx.mapper.WxSubjectMapper;
import com.ruoyi.wx.domain.WxSubject;
import com.ruoyi.wx.service.IWxSubjectService;

/**
 * 科目分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
@Service
public class WxSubjectServiceImpl implements IWxSubjectService 
{
    @Autowired
    private WxSubjectMapper wxSubjectMapper;

    /**
     * 查询科目分类
     * 
     * @param id 科目分类ID
     * @return 科目分类
     */
    @Override
    public WxSubject selectWxSubjectById(Long id)
    {
        return wxSubjectMapper.selectWxSubjectById(id);
    }

    /**
     * 查询科目分类列表
     * 
     * @param wxSubject 科目分类
     * @return 科目分类
     */
    @Override
    public List<WxSubject> selectWxSubjectList(WxSubject wxSubject)
    {
        return wxSubjectMapper.selectWxSubjectList(wxSubject);
    }

    /**
     * 新增科目分类
     * 
     * @param wxSubject 科目分类
     * @return 结果
     */
    @Override
    public int insertWxSubject(WxSubject wxSubject)
    {
        wxSubject.setCreateTime(DateUtils.getNowDate());
        return wxSubjectMapper.insertWxSubject(wxSubject);
    }

    /**
     * 修改科目分类
     * 
     * @param wxSubject 科目分类
     * @return 结果
     */
    @Override
    public int updateWxSubject(WxSubject wxSubject)
    {
        return wxSubjectMapper.updateWxSubject(wxSubject);
    }

    /**
     * 批量删除科目分类
     * 
     * @param ids 需要删除的科目分类ID
     * @return 结果
     */
    @Override
    public int deleteWxSubjectByIds(Long[] ids)
    {
        return wxSubjectMapper.deleteWxSubjectByIds(ids);
    }

    /**
     * 删除科目分类信息
     * 
     * @param id 科目分类ID
     * @return 结果
     */
    @Override
    public int deleteWxSubjectById(Long id)
    {
        return wxSubjectMapper.deleteWxSubjectById(id);
    }
}
