package com.ruoyi.web.controller.api;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.web.controller.api.entity.*;
import com.ruoyi.wx.domain.*;
import com.ruoyi.wx.domain.ResWxTeacher;
import com.ruoyi.wx.service.IWxAreaService;
import com.ruoyi.wx.service.IWxSubjectDetailsService;
import com.ruoyi.wx.service.IWxSubjectService;
import com.ruoyi.wx.service.IWxTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Api(tags = "微信小程序接口")
@RestController
@RequestMapping("/api")
public class ApiController extends BaseController {

    @Autowired
    private IWxSubjectService wxSubjectService;

    @Autowired
    private IWxSubjectDetailsService wxSubjectDetailsService;

    @Autowired
    private IWxAreaService wxAreaService;

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private IWxTeacherService wxTeacherService;

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
    public Response<RepUpload> uploadFile(@RequestBody MultipartFile file) throws Exception
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


    @PostMapping("/decodeUserInfo")
    @ApiOperation(value = "获取微信信息和手机号")
    private Response<RepWx> decodeUserInfo(PayDto payDto) {
        Response<RepWx> response = new Response<>();
        String encryptedData = payDto.getEncryptedData();
        String iv = payDto.getIv();
        String code = payDto.getCode();
        log.info("前端传入到decodeUserInfo 的encryptedData == " + encryptedData+"iv == " + iv+"code == "+code);
        Map<String,Object> map = new HashMap<>();
        if (code == null || code.length() == 0) {
            response.setErrorMessage("code 不能为空");
            return response;
        }
        String wechatAppId = "";
        String wechatSecretKey = "";
        String grantType = "authorization_code";
        String params = "appid=" + wechatAppId + "&secret="+wechatSecretKey+"&js_code=" + code + "&grant_type=" + grantType;
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        JSONObject json = JSONObject.parseObject(sr);

        String sessionKey = String.valueOf(json.get("session_key"));
        WXBizDataCrypt wxBizDataCrypt = new WXBizDataCrypt("wx_v3.appID.sp",sessionKey);
        JSONObject jsonObject = wxBizDataCrypt.decryptData(encryptedData, iv);

        if(null ==json.get("openid") && "".equals(json.get("openid"))){
            response.setErrorMessage("失败");
            return response;
        }else{
            RepWx userInfo = new RepWx();
            userInfo.setOpenId(json.get("openid").toString());
            userInfo.setPhoneNumber(jsonObject.get("phoneNumber").toString());
            log.info("jsonObject:"+jsonObject);
            log.info("手机号："+jsonObject.get("phoneNumber"));
            response.setResult(userInfo);
        }
        return response;
    }

    /**
     * 查询老师列表
     */
    @PostMapping("/list")
    @ApiOperation(value = "获取教师列表")
    public ResponsePage<List<WxTeacher>> list(ResWxTeacher resWxTeacher)
    {
        startPage(resWxTeacher.getPageNum(),resWxTeacher.getPageSize());
        List<WxTeacher> list = wxTeacherService.selectWxTeacherList(resWxTeacher);
        ResponsePage<List<WxTeacher>> response = new ResponsePage<>();
        response.setResult(list);
        response.setTotal(new PageInfo(list).getTotal());
        return response;
    }




}
