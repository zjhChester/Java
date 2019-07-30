package com.example.demo.controller;

import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HelloController {
    int visitCount=0;
    Map<String,String> map = new HashMap<String,String>();
    @ResponseBody
    @RequestMapping("10")
    public String c10()
    {
        return "二级域名测试成功";
    }
    @ResponseBody
    @RequestMapping("11")
    public String c11()
    {
        return "自动发布接口测试成功";
    }

    @ResponseBody
    @RequestMapping({"/","/hello","/index"})
    public String get(HttpServletRequest request){
        String ip = request.getHeader("X-Real-IP");
        String getip = getip(ip, request);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put(getip,simpleDateFormat.format(new Date())+"<br>");
        visitCount++;
        return "<div style='width:80%;margin:0;padding:15px;text-align:right;color:#464512;'>页面总浏览量："+visitCount+"</div><div style='width:80%;margin:0;padding:15px;text-align:right;color:#464512;'>ip访问记录："+map+"</div><div style='height:500px;line-height:500px;text-align:center;font-size:30px;left:30%;color:#343254;position:absolute;'>welcome to my web page</div>";
    }
    /**
     * 获取ip
     * @param ip
     * @param request
     * @return
     */
    public String getip(String ip,HttpServletRequest request){
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/chat")
    public String ws(){
        return  "chat";
    }
    @RequestMapping(value = "getAllUrl")
    @ResponseBody
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    public JSONArray getAllUrl() {
        StringBuilder sb = new StringBuilder();

        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        int i=1;
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();
            sb.append(i+":").append(info.getPatternsCondition()).append("--");
            sb.append(method.getMethod().getDeclaringClass()).append("--");
            sb.append(method.getMethod().getName()).append('\n');
            i++;
        }
        String[] split = sb.toString().split("\n");

        List<String> list = new ArrayList<String>();
        for (String s :
             split) {
            if(s.indexOf("|")>=0)
                list.add(s.substring(s.indexOf("[")+1,s.indexOf("|")));
            else
                list.add(s.substring(s.indexOf("[")+1,s.indexOf("]")));
        }

        list.remove("/error");
        list.remove("/error");
        return JSONArray.fromObject(list);
    }


}
