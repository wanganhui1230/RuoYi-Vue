package com.ruoyi.wx.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wx.mapper.WxAreaMapper;
import com.ruoyi.wx.domain.WxArea;
import com.ruoyi.wx.service.IWxAreaService;

/**
 * 区域Service业务层处理
 * 
 * @author w
 * @date 2021-02-23
 */
@Service
public class WxAreaServiceImpl implements IWxAreaService 
{
    @Autowired
    private WxAreaMapper wxAreaMapper;

    /**
     * 查询区域
     * 
     * @param id 区域ID
     * @return 区域
     */
    @Override
    public WxArea selectWxAreaById(Long id)
    {
        return wxAreaMapper.selectWxAreaById(id);
    }

    /**
     * 查询区域列表
     * 
     * @param wxArea 区域
     * @return 区域
     */
    @Override
    public List<WxArea> selectWxAreaList(WxArea wxArea)
    {
        return wxAreaMapper.selectWxAreaList(wxArea);
    }

    /**
     * 新增区域
     * 
     * @param wxArea 区域
     * @return 结果
     */
    @Override
    public int insertWxArea(WxArea wxArea)
    {
        wxArea.setCreateTime(DateUtils.getNowDate());
        return wxAreaMapper.insertWxArea(wxArea);
    }

    /**
     * 修改区域
     * 
     * @param wxArea 区域
     * @return 结果
     */
    @Override
    public int updateWxArea(WxArea wxArea)
    {
        return wxAreaMapper.updateWxArea(wxArea);
    }

    /**
     * 批量删除区域
     * 
     * @param ids 需要删除的区域ID
     * @return 结果
     */
    @Override
    public int deleteWxAreaByIds(Long[] ids)
    {
        return wxAreaMapper.deleteWxAreaByIds(ids);
    }

    /**
     * 删除区域信息
     * 
     * @param id 区域ID
     * @return 结果
     */
    @Override
    public int deleteWxAreaById(Long id)
    {
        return wxAreaMapper.deleteWxAreaById(id);
    }
}
