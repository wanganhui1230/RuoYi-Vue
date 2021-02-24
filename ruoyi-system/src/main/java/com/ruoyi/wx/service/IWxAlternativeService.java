package com.ruoyi.wx.service;

import java.util.List;
import com.ruoyi.wx.domain.WxAlternative;

/**
 * 备选老师Service接口
 * 
 * @author ruoyi
 * @date 2021-02-24
 */
public interface IWxAlternativeService 
{
    /**
     * 查询备选老师
     * 
     * @param traineeId 备选老师ID
     * @return 备选老师
     */
    public WxAlternative selectWxAlternativeById(Long traineeId);

    /**
     * 查询备选老师列表
     * 
     * @param wxAlternative 备选老师
     * @return 备选老师集合
     */
    public List<WxAlternative> selectWxAlternativeList(WxAlternative wxAlternative);

    /**
     * 新增备选老师
     * 
     * @param wxAlternative 备选老师
     * @return 结果
     */
    public int insertWxAlternative(WxAlternative wxAlternative);

    /**
     * 修改备选老师
     * 
     * @param wxAlternative 备选老师
     * @return 结果
     */
    public int updateWxAlternative(WxAlternative wxAlternative);

    /**
     * 批量删除备选老师
     * 
     * @param traineeIds 需要删除的备选老师ID
     * @return 结果
     */
    public int deleteWxAlternativeByIds(Long[] traineeIds);

    /**
     * 删除备选老师信息
     * 
     * @param traineeId 备选老师ID
     * @return 结果
     */
    public int deleteWxAlternativeById(Long traineeId);
}
