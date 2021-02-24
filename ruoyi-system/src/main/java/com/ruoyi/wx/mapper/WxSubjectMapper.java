package com.ruoyi.wx.mapper;

import java.util.List;
import com.ruoyi.wx.domain.WxSubject;

/**
 * 科目分类Mapper接口
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public interface WxSubjectMapper 
{
    /**
     * 查询科目分类
     * 
     * @param id 科目分类ID
     * @return 科目分类
     */
    public WxSubject selectWxSubjectById(Long id);

    /**
     * 查询科目分类列表
     * 
     * @param wxSubject 科目分类
     * @return 科目分类集合
     */
    public List<WxSubject> selectWxSubjectList(WxSubject wxSubject);

    /**
     * 新增科目分类
     * 
     * @param wxSubject 科目分类
     * @return 结果
     */
    public int insertWxSubject(WxSubject wxSubject);

    /**
     * 修改科目分类
     * 
     * @param wxSubject 科目分类
     * @return 结果
     */
    public int updateWxSubject(WxSubject wxSubject);

    /**
     * 删除科目分类
     * 
     * @param id 科目分类ID
     * @return 结果
     */
    public int deleteWxSubjectById(Long id);

    /**
     * 批量删除科目分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxSubjectByIds(Long[] ids);
}
