package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.wx.domain.WxTeacher;
import com.ruoyi.wx.service.IWxTeacherService;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 老师Controller
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
@RestController
@RequestMapping("/wx/teacher")
public class WxTeacherController extends BaseController
{
    @Autowired
    private IWxTeacherService wxTeacherService;

    /**
     * 查询老师列表
     */
    @PreAuthorize("@ss.hasPermi('wx:teacher:list')")
    @GetMapping("/list")
    public TableDataInfo list(WxTeacher wxTeacher)
    {
        startPage();
        List<WxTeacher> list = wxTeacherService.selectWxTeacherList(wxTeacher);
        return getDataTable(list);
    }

    /**
     * 导出老师列表
     */
    @PreAuthorize("@ss.hasPermi('wx:teacher:export')")
    @Log(title = "老师", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WxTeacher wxTeacher)
    {
        List<WxTeacher> list = wxTeacherService.selectWxTeacherList(wxTeacher);
        ExcelUtil<WxTeacher> util = new ExcelUtil<WxTeacher>(WxTeacher.class);
        return util.exportExcel(list, "teacher");
    }

    /**
     * 获取老师详细信息
     */
    @PreAuthorize("@ss.hasPermi('wx:teacher:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wxTeacherService.selectWxTeacherById(id));
    }

    /**
     * 新增老师
     */
    @PreAuthorize("@ss.hasPermi('wx:teacher:add')")
    @Log(title = "老师", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WxTeacher wxTeacher)
    {
        return toAjax(wxTeacherService.insertWxTeacher(wxTeacher));
    }

    /**
     * 修改老师
     */
    @PreAuthorize("@ss.hasPermi('wx:teacher:edit')")
    @Log(title = "老师", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxTeacher wxTeacher)
    {
        return toAjax(wxTeacherService.updateWxTeacher(wxTeacher));
    }

    /**
     * 删除老师
     */
    @PreAuthorize("@ss.hasPermi('wx:teacher:remove')")
    @Log(title = "老师", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wxTeacherService.deleteWxTeacherByIds(ids));
    }
}
