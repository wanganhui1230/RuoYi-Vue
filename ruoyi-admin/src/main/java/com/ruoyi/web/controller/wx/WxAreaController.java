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
import com.ruoyi.wx.domain.WxArea;
import com.ruoyi.wx.service.IWxAreaService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 区域Controller
 * 
 * @author w
 * @date 2021-02-23
 */
@RestController
@RequestMapping("/wx/area")
public class WxAreaController extends BaseController
{
    @Autowired
    private IWxAreaService wxAreaService;

    /**
     * 查询区域列表
     */
    @PreAuthorize("@ss.hasPermi('wx:area:list')")
    @GetMapping("/list")
    public TableDataInfo list(WxArea wxArea)
    {
        startPage();
        List<WxArea> list = wxAreaService.selectWxAreaList(wxArea);
        return getDataTable(list);
    }

    /**
     * 导出区域列表
     */
    @PreAuthorize("@ss.hasPermi('wx:area:export')")
    @Log(title = "区域", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WxArea wxArea)
    {
        List<WxArea> list = wxAreaService.selectWxAreaList(wxArea);
        ExcelUtil<WxArea> util = new ExcelUtil<WxArea>(WxArea.class);
        return util.exportExcel(list, "area");
    }

    /**
     * 获取区域详细信息
     */
    @PreAuthorize("@ss.hasPermi('wx:area:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wxAreaService.selectWxAreaById(id));
    }

    /**
     * 新增区域
     */
    @PreAuthorize("@ss.hasPermi('wx:area:add')")
    @Log(title = "区域", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WxArea wxArea)
    {
        return toAjax(wxAreaService.insertWxArea(wxArea));
    }

    /**
     * 修改区域
     */
    @PreAuthorize("@ss.hasPermi('wx:area:edit')")
    @Log(title = "区域", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxArea wxArea)
    {
        return toAjax(wxAreaService.updateWxArea(wxArea));
    }

    /**
     * 删除区域
     */
    @PreAuthorize("@ss.hasPermi('wx:area:remove')")
    @Log(title = "区域", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wxAreaService.deleteWxAreaByIds(ids));
    }
}
