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
import com.ruoyi.wx.domain.WxTrainee;
import com.ruoyi.wx.service.IWxTraineeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学员Controller
 * 
 * @author w
 * @date 2021-02-24
 */
@RestController
@RequestMapping("/wx/trainee")
public class WxTraineeController extends BaseController
{
    @Autowired
    private IWxTraineeService wxTraineeService;

    /**
     * 查询学员列表
     */
    @PreAuthorize("@ss.hasPermi('wx:trainee:list')")
    @GetMapping("/list")
    public TableDataInfo list(WxTrainee wxTrainee)
    {
        startPage();
        List<WxTrainee> list = wxTraineeService.selectWxTraineeList(wxTrainee);
        return getDataTable(list);
    }

    /**
     * 导出学员列表
     */
    @PreAuthorize("@ss.hasPermi('wx:trainee:export')")
    @Log(title = "学员", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WxTrainee wxTrainee)
    {
        List<WxTrainee> list = wxTraineeService.selectWxTraineeList(wxTrainee);
        ExcelUtil<WxTrainee> util = new ExcelUtil<WxTrainee>(WxTrainee.class);
        return util.exportExcel(list, "trainee");
    }

    /**
     * 获取学员详细信息
     */
    @PreAuthorize("@ss.hasPermi('wx:trainee:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wxTraineeService.selectWxTraineeById(id));
    }

    /**
     * 新增学员
     */
    @PreAuthorize("@ss.hasPermi('wx:trainee:add')")
    @Log(title = "学员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WxTrainee wxTrainee)
    {
        return toAjax(wxTraineeService.insertWxTrainee(wxTrainee));
    }

    /**
     * 修改学员
     */
    @PreAuthorize("@ss.hasPermi('wx:trainee:edit')")
    @Log(title = "学员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxTrainee wxTrainee)
    {
        return toAjax(wxTraineeService.updateWxTrainee(wxTrainee));
    }

    /**
     * 删除学员
     */
    @PreAuthorize("@ss.hasPermi('wx:trainee:remove')")
    @Log(title = "学员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wxTraineeService.deleteWxTraineeByIds(ids));
    }
}
