package com.ruoyi.wx.mapper;

import java.util.List;
import com.ruoyi.wx.domain.WxAlternative;

/**
 * 备选老师Mapper接口
 * 
 * @author w
 * @date 2021-02-24
 */
public interface WxAlternativeMapper 
{
    /**
     * 查询备选老师
     * 
     * @param id 备选老师ID
     * @return 备选老师
     */
    public WxAlternative selectWxAlternativeById(Long id);

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
     * 删除备选老师
     * 
     * @param id 备选老师ID
     * @return 结果
     */
    public int deleteWxAlternativeById(Long id);

    /**
     * 批量删除备选老师
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxAlternativeByIds(Long[] ids);
}
