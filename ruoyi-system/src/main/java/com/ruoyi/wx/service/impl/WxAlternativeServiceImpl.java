package com.ruoyi.wx.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wx.mapper.WxAlternativeMapper;
import com.ruoyi.wx.domain.WxAlternative;
import com.ruoyi.wx.service.IWxAlternativeService;

/**
 * 备选老师Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
@Service
public class WxAlternativeServiceImpl implements IWxAlternativeService 
{
    @Autowired
    private WxAlternativeMapper wxAlternativeMapper;

    /**
     * 查询备选老师
     * 
     * @param traineeId 备选老师ID
     * @return 备选老师
     */
    @Override
    public WxAlternative selectWxAlternativeById(Long traineeId)
    {
        return wxAlternativeMapper.selectWxAlternativeById(traineeId);
    }

    /**
     * 查询备选老师列表
     * 
     * @param wxAlternative 备选老师
     * @return 备选老师
     */
    @Override
    public List<WxAlternative> selectWxAlternativeList(WxAlternative wxAlternative)
    {
        return wxAlternativeMapper.selectWxAlternativeList(wxAlternative);
    }

    /**
     * 新增备选老师
     * 
     * @param wxAlternative 备选老师
     * @return 结果
     */
    @Override
    public int insertWxAlternative(WxAlternative wxAlternative)
    {
        wxAlternative.setCreateTime(DateUtils.getNowDate());
        return wxAlternativeMapper.insertWxAlternative(wxAlternative);
    }

    /**
     * 修改备选老师
     * 
     * @param wxAlternative 备选老师
     * @return 结果
     */
    @Override
    public int updateWxAlternative(WxAlternative wxAlternative)
    {
        return wxAlternativeMapper.updateWxAlternative(wxAlternative);
    }

    /**
     * 批量删除备选老师
     * 
     * @param traineeIds 需要删除的备选老师ID
     * @return 结果
     */
    @Override
    public int deleteWxAlternativeByIds(Long[] traineeIds)
    {
        return wxAlternativeMapper.deleteWxAlternativeByIds(traineeIds);
    }

    /**
     * 删除备选老师信息
     * 
     * @param traineeId 备选老师ID
     * @return 结果
     */
    @Override
    public int deleteWxAlternativeById(WxAlternative wxAlternative)
    {
        return wxAlternativeMapper.deleteWxAlternativeById(wxAlternative);
    }
}
