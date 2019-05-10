package com.cloudp.controller;


import com.cloudp.entity.User;
import com.cloudp.service.Service;
import com.cloudp.service.ServiceImpl;
import com.cloudp.utils.EnterPriseXmailUtils;
import com.cloudp.utils.Md5Utils;
import com.cloudp.utils.SmsUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class LoginController {
    String Code;

    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) throws IOException {
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)){
            User user = new User(username,Md5Utils.getMd5(password));
            Service service = new ServiceImpl();
            String result = service.login(user);
            if("success".equals(result)){
            session.setAttribute("loginUser",user);
            return "redirect:/";
            }else{
                map.put("login_msg","用户名或密码错误！");
                return "login-register";
            }
        }else{
            map.put("login_msg","请输入用户名和密码");
            return "login-register";
        }

    }
    @PostMapping(value = "/user/regist")
    public String regist(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email,
                         @RequestParam("code") String code, Map<String,Object> map) throws IOException {


        if(!code.equals(Code) || StringUtils.isEmpty(code)){
            System.out.println("正确验证码为*************"+Code);
            map.put("regist_msg","验证码有误");
            return "login-register";
        }
        else if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)&& !StringUtils.isEmpty(email)) {
            User user = new User(username, Md5Utils.getMd5(password),email);
            ServiceImpl service = new ServiceImpl();
                String result = service.regist(user);
                if ("success".equals(result)) {
                    map.put("regist_msg", "<script type=\"text/javascript\">alert('注册成功，即将跳转到登录页面~')</script>");
                    return "success";
                } else {
                    result = result.equals("username is exist")?"用户名已存在":"邮箱已注册请登录";
                    map.put("regist_msg", result);
                    return "login-register";
                }
        } else {
            map.put("regist_msg", "请完善注册信息");
            return "login-register";
        }
    }


    @ResponseBody
    @PostMapping("user/sendmail")
    public void getcode(@RequestParam("email") String email){
        SmsUtils utils = new SmsUtils();
        String code = utils.verificationCode();
        Code = code;
        System.out.println("生成验证码成功");
        new EnterPriseXmailUtils().send("云鸽官方","欢迎加入我们->云鸽注册",code,email);

    }
}

