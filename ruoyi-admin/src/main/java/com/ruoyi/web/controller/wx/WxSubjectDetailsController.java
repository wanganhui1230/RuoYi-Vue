package com.ruoyi.web.controller.wx.controller;

import java.util.List;

import com.ruoyi.wx.domain.WxSubject;
import com.ruoyi.wx.service.IWxSubjectService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wx.domain.WxSubjectDetails;
import com.ruoyi.wx.service.IWxSubjectDetailsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科目详情Controller
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
@RestController
@RequestMapping("/wx/details")
public class WxSubjectDetailsController extends BaseController
{
    @Autowired
    private IWxSubjectDetailsService wxSubjectDetailsService;

    @Autowired
    private IWxSubjectService wxSubjectService;

    /**
     * 查询科目详情列表
     */
    @PreAuthorize("@ss.hasPermi('wx:details:list')")
    @GetMapping("/list")
    public TableDataInfo list(WxSubjectDetails wxSubjectDetails)
    {
        startPage();
        List<WxSubjectDetails> list = wxSubjectDetailsService.selectWxSubjectDetailsList(wxSubjectDetails);
        return getDataTable(list);
    }

    /**
     * 导出科目详情列表
     */
    @PreAuthorize("@ss.hasPermi('wx:details:export')")
    @Log(title = "科目详情", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WxSubjectDetails wxSubjectDetails)
    {
        List<WxSubjectDetails> list = wxSubjectDetailsService.selectWxSubjectDetailsList(wxSubjectDetails);
        ExcelUtil<WxSubjectDetails> util = new ExcelUtil<WxSubjectDetails>(WxSubjectDetails.class);
        return util.exportExcel(list, "details");
    }

    /**
     * 获取科目详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('wx:details:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wxSubjectDetailsService.selectWxSubjectDetailsById(id));
    }

    /**
     * 新增科目详情
     */
    @PreAuthorize("@ss.hasPermi('wx:details:add')")
    @Log(title = "科目详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WxSubjectDetails wxSubjectDetails)
    {
        WxSubject wsb = wxSubjectService.selectWxSubjectById(wxSubjectDetails.getWxSubjectDetails());
        wxSubjectDetails.setFullName(wsb.getName()+wxSubjectDetails.getName());
        return toAjax(wxSubjectDetailsService.insertWxSubjectDetails(wxSubjectDetails));
    }

    /**
     * 修改科目详情
     */
    @PreAuthorize("@ss.hasPermi('wx:details:edit')")
    @Log(title = "科目详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxSubjectDetails wxSubjectDetails)
    {
        WxSubject wsb = wxSubjectService.selectWxSubjectById(wxSubjectDetails.getWxSubjectDetails());
        wxSubjectDetails.setFullName(wsb.getName()+wxSubjectDetails.getName());
        return toAjax(wxSubjectDetailsService.updateWxSubjectDetails(wxSubjectDetails));
    }

    /**
     * 删除科目详情
     */
    @PreAuthorize("@ss.hasPermi('wx:details:remove')")
    @Log(title = "科目详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wxSubjectDetailsService.deleteWxSubjectDetailsByIds(ids));
    }
}
