package com.ruoyi.wx.mapper;

import java.util.List;
import com.ruoyi.wx.domain.WxTrainee;

/**
 * 学员Mapper接口
 * 
 * @author w
 * @date 2021-02-24
 */
public interface WxTraineeMapper 
{
    /**
     * 查询学员
     * 
     * @param id 学员ID
     * @return 学员
     */
    public WxTrainee selectWxTraineeById(Long id);

    /**
     * 查询学员
     *
     * @param openId 学员ID
     * @return 学员
     */
    public WxTrainee selectWxTraineeByOpenId(String openId);

    /**
     * 查询学员列表
     * 
     * @param wxTrainee 学员
     * @return 学员集合
     */
    public List<WxTrainee> selectWxTraineeList(WxTrainee wxTrainee);

    /**
     * 新增学员
     * 
     * @param wxTrainee 学员
     * @return 结果
     */
    public int insertWxTrainee(WxTrainee wxTrainee);

    /**
     * 修改学员
     * 
     * @param wxTrainee 学员
     * @return 结果
     */
    public int updateWxTrainee(WxTrainee wxTrainee);

    /**
     * 删除学员
     * 
     * @param id 学员ID
     * @return 结果
     */
    public int deleteWxTraineeById(Long id);

    /**
     * 批量删除学员
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxTraineeByIds(Long[] ids);
}
