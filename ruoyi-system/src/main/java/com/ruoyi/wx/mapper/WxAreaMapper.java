package com.ruoyi.wx.mapper;

import java.util.List;
import com.ruoyi.wx.domain.WxArea;

/**
 * 区域Mapper接口
 * 
 * @author w
 * @date 2021-02-23
 */
public interface WxAreaMapper 
{
    /**
     * 查询区域
     * 
     * @param id 区域ID
     * @return 区域
     */
    public WxArea selectWxAreaById(Long id);

    /**
     * 查询区域列表
     * 
     * @param wxArea 区域
     * @return 区域集合
     */
    public List<WxArea> selectWxAreaList(WxArea wxArea);

    /**
     * 新增区域
     * 
     * @param wxArea 区域
     * @return 结果
     */
    public int insertWxArea(WxArea wxArea);

    /**
     * 修改区域
     * 
     * @param wxArea 区域
     * @return 结果
     */
    public int updateWxArea(WxArea wxArea);

    /**
     * 删除区域
     * 
     * @param id 区域ID
     * @return 结果
     */
    public int deleteWxAreaById(Long id);

    /**
     * 批量删除区域
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxAreaByIds(Long[] ids);
}
