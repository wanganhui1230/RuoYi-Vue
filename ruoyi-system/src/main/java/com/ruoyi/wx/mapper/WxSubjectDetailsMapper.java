package com.ruoyi.wx.mapper;

import java.util.List;
import com.ruoyi.wx.domain.WxSubjectDetails;

/**
 * 科目详情Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public interface WxSubjectDetailsMapper 
{
    /**
     * 查询科目详情
     * 
     * @param id 科目详情ID
     * @return 科目详情
     */
    public WxSubjectDetails selectWxSubjectDetailsById(Long id);

    /**
     * 查询科目详情列表
     * 
     * @param wxSubjectDetails 科目详情
     * @return 科目详情集合
     */
    public List<WxSubjectDetails> selectWxSubjectDetailsList(WxSubjectDetails wxSubjectDetails);

    /**
     * 新增科目详情
     * 
     * @param wxSubjectDetails 科目详情
     * @return 结果
     */
    public int insertWxSubjectDetails(WxSubjectDetails wxSubjectDetails);

    /**
     * 修改科目详情
     * 
     * @param wxSubjectDetails 科目详情
     * @return 结果
     */
    public int updateWxSubjectDetails(WxSubjectDetails wxSubjectDetails);

    /**
     * 删除科目详情
     * 
     * @param id 科目详情ID
     * @return 结果
     */
    public int deleteWxSubjectDetailsById(Long id);

    /**
     * 批量删除科目详情
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxSubjectDetailsByIds(Long[] ids);
}
