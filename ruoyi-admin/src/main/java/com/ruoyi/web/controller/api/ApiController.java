package com.ruoyi.web.controller.api;


import com.alibaba.fastjson.JSON;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.web.controller.api.entity.RepArea;
import com.ruoyi.web.controller.api.entity.RepTreelist;
import com.ruoyi.web.controller.api.entity.RepUpload;
import com.ruoyi.web.controller.api.entity.Response;
import com.ruoyi.wx.domain.WxArea;
import com.ruoyi.wx.domain.WxSubject;
import com.ruoyi.wx.domain.WxSubjectDetails;
import com.ruoyi.wx.service.IWxAreaService;
import com.ruoyi.wx.service.IWxSubjectDetailsService;
import com.ruoyi.wx.service.IWxSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Api(tags = "微信小程序接口")
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private IWxSubjectService wxSubjectService;

    @Autowired
    private IWxSubjectDetailsService wxSubjectDetailsService;

    @Autowired
    private IWxAreaService wxAreaService;

    @Autowired
    private ServerConfig serverConfig;

    /**
     * 获取树菜单
     */
    @GetMapping("/getTreelist")
    @ApiOperation(value = "获取科目二级菜单")
    public Response<List<RepTreelist>> getTreelist()
    {
        Response<List<RepTreelist>> response = new Response<>();
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
        List<RepTreelist> igs = gtl.stream().map(o ->{
            RepTreelist ig = JSON.parseObject(JSON.toJSONString(o), RepTreelist.class);
            return ig;
        }).collect(Collectors.toList());
        response.setResult(igs);
        return response;
    }

    /**
     * 查询区域列表
     */
    @GetMapping("/getArealist")
    @ApiOperation(value = "获取区域")
    public Response<List<RepArea>> getArealist()
    {
        Response<List<RepArea>> response = new Response<>();
        WxArea wxArea = new WxArea();
        List<WxArea> list = wxAreaService.selectWxAreaList(wxArea);
        List<RepArea> ras = new ArrayList<>();
        list.stream().forEach(o -> {
            RepArea ra = new RepArea();
            ra.setId(o.getId()+"");
            ra.setName(o.getName());
            ras.add(ra);
        });
        response.setResult(ras);
        return response;
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/upload")
    @ApiOperation(value = "通用上传请求")
    public Response<RepUpload> uploadFile(MultipartFile file) throws Exception
    {
        Response<RepUpload> response = new Response<>();
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            RepUpload ajax = new RepUpload();
            ajax.setFileName(fileName);
            ajax.setUrl( url);
            response.setResult(ajax);
            return response;
        }
        catch (Exception e)
        {
            response.setErrorMessage("上传失败");
            return response;
        }
    }

}
