package com.ruoyi.web.controller.wx;

import java.util.List;
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
import com.ruoyi.wx.domain.WxAlternative;
import com.ruoyi.wx.service.IWxAlternativeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 备选老师Controller
 * 
 * @author w
 * @date 2021-02-24
 */
@RestController
@RequestMapping("/wx/alternative")
public class WxAlternativeController extends BaseController
{
    @Autowired
    private IWxAlternativeService wxAlternativeService;

    /**
     * 查询备选老师列表
     */
    @PreAuthorize("@ss.hasPermi('wx:alternative:list')")
    @GetMapping("/list")
    public TableDataInfo list(WxAlternative wxAlternative)
    {
        startPage();
        List<WxAlternative> list = wxAlternativeService.selectWxAlternativeList(wxAlternative);
        return getDataTable(list);
    }

    /**
     * 导出备选老师列表
     */
    @PreAuthorize("@ss.hasPermi('wx:alternative:export')")
    @Log(title = "备选老师", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WxAlternative wxAlternative)
    {
        List<WxAlternative> list = wxAlternativeService.selectWxAlternativeList(wxAlternative);
        ExcelUtil<WxAlternative> util = new ExcelUtil<WxAlternative>(WxAlternative.class);
        return util.exportExcel(list, "alternative");
    }

    /**
     * 获取备选老师详细信息
     */
    @PreAuthorize("@ss.hasPermi('wx:alternative:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wxAlternativeService.selectWxAlternativeById(id));
    }

    /**
     * 新增备选老师
     */
    @PreAuthorize("@ss.hasPermi('wx:alternative:add')")
    @Log(title = "备选老师", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WxAlternative wxAlternative)
    {
        return toAjax(wxAlternativeService.insertWxAlternative(wxAlternative));
    }

    /**
     * 修改备选老师
     */
    @PreAuthorize("@ss.hasPermi('wx:alternative:edit')")
    @Log(title = "备选老师", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxAlternative wxAlternative)
    {
        return toAjax(wxAlternativeService.updateWxAlternative(wxAlternative));
    }

    /**
     * 删除备选老师
     */
    @PreAuthorize("@ss.hasPermi('wx:alternative:remove')")
    @Log(title = "备选老师", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wxAlternativeService.deleteWxAlternativeByIds(ids));
    }
}
