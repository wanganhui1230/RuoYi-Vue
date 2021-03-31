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
import com.ruoyi.wx.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;
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

    @Autowired
    private IWxTraineeService wxTraineeService;

    @Autowired
    private IWxAlternativeService wxAlternativeService;

    /**
     * 获取树菜单
     */
    @PostMapping("/getTreelist")
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
    @PostMapping("/getArealist")
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
            e.printStackTrace();
            response.setErrorMessage("上传失败");
            return response;
        }
    }


    @PostMapping({"/decodeUserInfo"})
    @ApiOperation(value = "获取微信信息openid")
    private Map<String, Object> decodeUserInfo(String code) {
        Map<String, Object> map = new HashMap();
        if (code != null && code.length() != 0) {
            String wechatAppId = "wxabcbf17a4b2f6168";
            String wechatSecretKey = "48eb021c3ca2bd05d7e736777194b877";
            String grantType = "authorization_code";
            String params = "appid=" + wechatAppId + "&secret=" + wechatSecretKey + "&js_code=" + code + "&grant_type=" + grantType;
            String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
            JSONObject json = JSONObject.parseObject(sr);
            if (null == json.get("openid") && "".equals(json.get("openid"))) {
                map.put("code", "500");
                map.put("msg", "失败");
            } else {
                Map<String, Object> userInfo = new HashMap();
                userInfo.put("openId", json.get("openid"));
                map.put("data", userInfo);
                map.put("code", "0");
                map.put("msg", "成功");
            }

            return map;
        } else {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
    }

//    @PostMapping("/decodeUserInfo")
//    @ApiOperation(value = "获取微信信息和手机号")
//    private Response<RepWx> decodeUserInfo(PayDto payDto) {
//        Response<RepWx> response = new Response<>();
//        String encryptedData = payDto.getEncryptedData();
//        String iv = payDto.getIv();
//        String code = payDto.getCode();
//        log.info("前端传入到decodeUserInfo 的encryptedData == " + encryptedData+"iv == " + iv+"code == "+code);
//        Map<String,Object> map = new HashMap<>();
//        if (code == null || code.length() == 0) {
//            response.setErrorMessage("code 不能为空");
//            return response;
//        }
//        String wechatAppId = "";
//        String wechatSecretKey = "";
//        String grantType = "authorization_code";
//        String params = "appid=" + wechatAppId + "&secret="+wechatSecretKey+"&js_code=" + code + "&grant_type=" + grantType;
//        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
//        JSONObject json = JSONObject.parseObject(sr);
//
//        String sessionKey = String.valueOf(json.get("session_key"));
//        WXBizDataCrypt wxBizDataCrypt = new WXBizDataCrypt("wx_v3.appID.sp",sessionKey);
//        JSONObject jsonObject = wxBizDataCrypt.decryptData(encryptedData, iv);
//
//        if(null ==json.get("openid") && "".equals(json.get("openid"))){
//            response.setErrorMessage("失败");
//            return response;
//        }else{
//            RepWx userInfo = new RepWx();
//            userInfo.setOpenId(json.get("openid").toString());
//            userInfo.setPhoneNumber(jsonObject.get("phoneNumber").toString());
//            log.info("jsonObject:"+jsonObject);
//            log.info("手机号："+jsonObject.get("phoneNumber"));
//            response.setResult(userInfo);
//        }
//        return response;
//    }

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

    /**
     * 查询老师信息
     */
    @PostMapping("/getTeacherId")
    @ApiOperation(value = "查询老师信息")
    public Response<WxTeacher> getTeacherId(Long id)
    {
        WxTeacher wt = wxTeacherService.selectWxTeacherById(id);
        Response<WxTeacher> response = new Response<>();
        response.setResult(wt);
        return response;
    }

    /**
     * 增加老师热度
     */
    @PostMapping("/addHeat")
    @ApiOperation(value = "增加老师热度")
    public Response addHeat(ResHeat resHeat)
    {
        Response response = new Response<>();
        WxTeacher wxTeacher = new WxTeacher();
        WxTeacher wt = wxTeacherService.selectWxTeacherById(resHeat.getId());
        wxTeacher.setId(resHeat.getId());
        wxTeacher.setHeat(Integer.parseInt(wt.getHeat())+1+"");
        int code =  wxTeacherService.updateWxTeacher(wxTeacher);
        if(code>0){
            response.setResult("成功");
        }else{
            response.setErrorMessage("失败");
        }
        return response;
    }

    /**
     * 新增老师
     */
    @PostMapping("/addWxTeacher")
    @ApiOperation(value = "新增老师信息")
    public Response add(WxTeacher wxTeacher)
    {
        Response response = new Response<>();
        wxTeacher.setStatus("未认证");
        wxTeacher.setLoginTime(new Date());
        WxSubjectDetails wxSubjectDetails = new WxSubjectDetails();
        wxSubjectDetails.setFullName(wxTeacher.getSubjectName());
        List<WxSubjectDetails> wsd = wxSubjectDetailsService.selectWxSubjectDetailsList(wxSubjectDetails);
        wxTeacher.setSubject(wsd.get(0).getId()+"");
        int code = wxTeacherService.insertWxTeacher(wxTeacher);
        if(code>0){
            response.setResult("成功");
        }else{
            response.setErrorMessage("失败");
        }
        return response;
    }

    /**
     * 修改老师
     */
    @PostMapping("/editWxTeacher")
    @ApiOperation(value = "修改老师信息")
    public Response edit(WxTeacher wxTeacher)
    {
        Response response = new Response<>();
        int code = wxTeacherService.updateWxTeacher(wxTeacher);
        if(code>0){
            response.setResult("成功");
        }else{
            response.setErrorMessage("失败");
        }
        return response;
    }


    /**
     * 新增学员
     */
    @PostMapping("/addWxTrainee")
    @ApiOperation(value = "新增学员")
    public Response addWxTrainee( WxTrainee wxTrainee)
    {
        Response response = new Response<>();
        int code = wxTraineeService.insertWxTrainee(wxTrainee);

        if(code>0){
            response.setResult("成功");
        }else{
            response.setErrorMessage("失败");
        }
        return response;
    }

    /**
     * 查看是否登录
     */
    @PostMapping("/IsNotLogin")
    @ApiOperation(value = "查看是否登录")
    public Response<RepUser> IsNotLogin( ResIsNotLogin resIsNotLogin)
    {
        Response<RepUser> response = new Response<>();
        RepUser repUser = new RepUser();
        WxTrainee wti = wxTraineeService.selectWxTraineeByOpenId(resIsNotLogin.getOpenId());
        if(wti!=null){
            repUser.setId(wti.getId());
            repUser.setName(wti.getName());
            repUser.setType(2);
            repUser.setStatus(true);
        }
        WxTeacher wth = wxTeacherService.selectWxTeacherByOpenId(resIsNotLogin.getOpenId());
        if(wth!=null){
            repUser.setId(wth.getId());
            repUser.setName(wth.getName());
            repUser.setType(1);
            repUser.setStatus(true);
        }
        response.setResult(repUser);
        return response;
    }


    /**
     * 新增备选老师
     */

    @PostMapping("/addWxAlternative")
    @ApiOperation(value = "新增备选老师")
    public Response addWxAlternative(WxAlternative wxAlternative)
    {
        Response response = new Response<>();
        int code = wxAlternativeService.insertWxAlternative(wxAlternative);

        if(code>0){
            response.setResult("成功");
        }else{
            response.setErrorMessage("失败");
        }
        return response;
    }

    /**
     * 邀请备选老师
     */
    @PostMapping("/editWxAlternative")
    @ApiOperation(value = "邀请备选老师")
    public Response editWxAlternative(WxAlternative wxAlternative)
    {
        Response response = new Response<>();
        int code = wxAlternativeService.updateWxAlternative(wxAlternative);

        if(code>0){
            response.setResult("成功");
        }else{
            response.setErrorMessage("失败");
        }
        return response;
    }

    @PostMapping("/selectWxTeacher")
    @ApiOperation(value = "获取备选老师列表")
    public Response<List<WxTeacher>> selectWxTeacher(@ApiParam("学员id") @RequestParam Long id)
    {
        Response<List<WxTeacher>> response = new Response<>();
        List<WxTeacher> wxTeacher = wxTeacherService.selectWxTeacher(id);
        response.setResult(wxTeacher);
        return response;
    }

    /**
     * 删除备选老师
     */
    @PostMapping("deleteWxAlternative")
    @ApiOperation(value = "删除备选老师")
    public Response deleteWxAlternative(@ApiParam("学员id") @RequestParam Long traineeId
            ,@ApiParam("老师id") @RequestParam Long teacherId)
    {
        Response response = new Response<>();
        WxAlternative wxAlternative = new WxAlternative();
        wxAlternative.setTeacherId(teacherId);
        wxAlternative.setTraineeId(traineeId);
        int code = wxAlternativeService.deleteWxAlternativeById(wxAlternative);

        if(code>0){
            response.setResult("成功");
        }else{
            response.setErrorMessage("失败");
        }
        return response;
    }



}
