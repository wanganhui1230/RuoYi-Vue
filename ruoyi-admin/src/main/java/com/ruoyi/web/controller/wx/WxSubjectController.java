package com.ruoyi.web.controller.wx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ruoyi.wx.domain.WxSubjectDetails;
import com.ruoyi.wx.service.IWxSubjectDetailsService;
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
import com.ruoyi.wx.domain.WxSubject;
import com.ruoyi.wx.service.IWxSubjectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科目分类Controller
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
@RestController
@RequestMapping("/wx/subject")
public class WxSubjectController extends BaseController
{
    @Autowired
    private IWxSubjectService wxSubjectService;

    @Autowired
    private IWxSubjectDetailsService wxSubjectDetailsService;

    /**
     * 获取树菜单
     */
    @GetMapping("/getTreelist")
    public AjaxResult getTreelist()
    {
        WxSubject wxSubject = new WxSubject();
        List<WxSubject> ws = wxSubjectService.selectWxSubjectList(wxSubject);
        WxSubjectDetails wxSubjectDetails = new WxSubjectDetails();
        List<WxSubjectDetails> wsd = wxSubjectDetailsService.selectWxSubjectDetailsList(wxSubjectDetails);
        List<Map> gtl = new ArrayList<>();
        ws.stream().forEach(o -> {
            Map wls = new HashMap();
            List<Map> wsl = new ArrayList<>();
            wsd.stream().filter(o1 -> o1.getWxSubjectDetails() == o.getId()).forEach(o2 ->{
                Map map = new HashMap();
                map.put("id",o2.getId());
                map.put("label",o2.getName());
                wsl.add(map);
            });
            wls.put("children",wsl);
            wls.put("id",o.getId());
            wls.put("label",o.getName());
            gtl.add(wls);
        });
        return AjaxResult.success(gtl);
    }

    /**
     * 获取科目全称
     */
    @GetMapping("/getSubjectName")
    public AjaxResult getSubjectName()
    {
        WxSubject wxSubject = new WxSubject();
        List<WxSubject> ws = wxSubjectService.selectWxSubjectList(wxSubject);
        WxSubjectDetails wxSubjectDetails = new WxSubjectDetails();
        List<WxSubjectDetails> wsd = wxSubjectDetailsService.selectWxSubjectDetailsList(wxSubjectDetails);
        List<WxSubjectDetails> wsds = wsd.stream().map(o ->{
            ws.stream().filter(o1 -> o1.getId() == o.getWxSubjectDetails()).forEach(o2 ->{
                o.setName(o2.getName()+o.getName());
            });
            return o;
        }).collect(Collectors.toList());

        return AjaxResult.success(wsds);
    }

    /**
     * 查询科目分类列表
     */
    @PreAuthorize("@ss.hasPermi('wx:subject:list')")
    @GetMapping("/list")
    public TableDataInfo list(WxSubject wxSubject)
    {
        startPage();
        List<WxSubject> list = wxSubjectService.selectWxSubjectList(wxSubject);
        return getDataTable(list);
    }

    /**
     * 导出科目分类列表
     */
    @PreAuthorize("@ss.hasPermi('wx:subject:export')")
    @Log(title = "科目分类", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WxSubject wxSubject)
    {
        List<WxSubject> list = wxSubjectService.selectWxSubjectList(wxSubject);
        ExcelUtil<WxSubject> util = new ExcelUtil<WxSubject>(WxSubject.class);
        return util.exportExcel(list, "subject");
    }

    /**
     * 获取科目分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('wx:subject:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wxSubjectService.selectWxSubjectById(id));
    }

    /**
     * 新增科目分类
     */
    @PreAuthorize("@ss.hasPermi('wx:subject:add')")
    @Log(title = "科目分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WxSubject wxSubject)
    {
        return toAjax(wxSubjectService.insertWxSubject(wxSubject));
    }

    /**
     * 修改科目分类
     */
    @PreAuthorize("@ss.hasPermi('wx:subject:edit')")
    @Log(title = "科目分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxSubject wxSubject)
    {
        return toAjax(wxSubjectService.updateWxSubject(wxSubject));
    }

    /**
     * 删除科目分类
     */
    @PreAuthorize("@ss.hasPermi('wx:subject:remove')")
    @Log(title = "科目分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wxSubjectService.deleteWxSubjectByIds(ids));
    }
}
