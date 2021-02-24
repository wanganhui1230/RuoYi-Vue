package com.ruoyi.wx.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wx.mapper.WxTraineeMapper;
import com.ruoyi.wx.domain.WxTrainee;
import com.ruoyi.wx.service.IWxTraineeService;

/**
 * 学员Service业务层处理
 * 
 * @author w
 * @date 2021-02-24
 */
@Service
public class WxTraineeServiceImpl implements IWxTraineeService 
{
    @Autowired
    private WxTraineeMapper wxTraineeMapper;

    /**
     * 查询学员
     * 
     * @param id 学员ID
     * @return 学员
     */
    @Override
    public WxTrainee selectWxTraineeById(Long id)
    {
        return wxTraineeMapper.selectWxTraineeById(id);
    }

    /**
     * 查询学员列表
     * 
     * @param wxTrainee 学员
     * @return 学员
     */
    @Override
    public List<WxTrainee> selectWxTraineeList(WxTrainee wxTrainee)
    {
        return wxTraineeMapper.selectWxTraineeList(wxTrainee);
    }

    /**
     * 新增学员
     * 
     * @param wxTrainee 学员
     * @return 结果
     */
    @Override
    public int insertWxTrainee(WxTrainee wxTrainee)
    {
        wxTrainee.setCreateTime(DateUtils.getNowDate());
        return wxTraineeMapper.insertWxTrainee(wxTrainee);
    }

    /**
     * 修改学员
     * 
     * @param wxTrainee 学员
     * @return 结果
     */
    @Override
    public int updateWxTrainee(WxTrainee wxTrainee)
    {
        return wxTraineeMapper.updateWxTrainee(wxTrainee);
    }

    /**
     * 批量删除学员
     * 
     * @param ids 需要删除的学员ID
     * @return 结果
     */
    @Override
    public int deleteWxTraineeByIds(Long[] ids)
    {
        return wxTraineeMapper.deleteWxTraineeByIds(ids);
    }

    /**
     * 删除学员信息
     * 
     * @param id 学员ID
     * @return 结果
     */
    @Override
    public int deleteWxTraineeById(Long id)
    {
        return wxTraineeMapper.deleteWxTraineeById(id);
    }
}
