package com.ruoyi.wx.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wx.mapper.WxSubjectDetailsMapper;
import com.ruoyi.wx.domain.WxSubjectDetails;
import com.ruoyi.wx.service.IWxSubjectDetailsService;

/**
 * 科目详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
@Service
public class WxSubjectDetailsServiceImpl implements IWxSubjectDetailsService 
{
    @Autowired
    private WxSubjectDetailsMapper wxSubjectDetailsMapper;

    /**
     * 查询科目详情
     * 
     * @param id 科目详情ID
     * @return 科目详情
     */
    @Override
    public WxSubjectDetails selectWxSubjectDetailsById(Long id)
    {
        return wxSubjectDetailsMapper.selectWxSubjectDetailsById(id);
    }

    /**
     * 查询科目详情列表
     * 
     * @param wxSubjectDetails 科目详情
     * @return 科目详情
     */
    @Override
    public List<WxSubjectDetails> selectWxSubjectDetailsList(WxSubjectDetails wxSubjectDetails)
    {
        return wxSubjectDetailsMapper.selectWxSubjectDetailsList(wxSubjectDetails);
    }

    /**
     * 新增科目详情
     * 
     * @param wxSubjectDetails 科目详情
     * @return 结果
     */
    @Override
    public int insertWxSubjectDetails(WxSubjectDetails wxSubjectDetails)
    {
        wxSubjectDetails.setCreateTime(DateUtils.getNowDate());
        return wxSubjectDetailsMapper.insertWxSubjectDetails(wxSubjectDetails);
    }

    /**
     * 修改科目详情
     * 
     * @param wxSubjectDetails 科目详情
     * @return 结果
     */
    @Override
    public int updateWxSubjectDetails(WxSubjectDetails wxSubjectDetails)
    {
        return wxSubjectDetailsMapper.updateWxSubjectDetails(wxSubjectDetails);
    }

    /**
     * 批量删除科目详情
     * 
     * @param ids 需要删除的科目详情ID
     * @return 结果
     */
    @Override
    public int deleteWxSubjectDetailsByIds(Long[] ids)
    {
        return wxSubjectDetailsMapper.deleteWxSubjectDetailsByIds(ids);
    }

    /**
     * 删除科目详情信息
     * 
     * @param id 科目详情ID
     * @return 结果
     */
    @Override
    public int deleteWxSubjectDetailsById(Long id)
    {
        return wxSubjectDetailsMapper.deleteWxSubjectDetailsById(id);
    }
}
