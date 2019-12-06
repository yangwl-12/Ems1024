package com.yang.controller;

import com.yang.entity.User;
import com.yang.service.UserService;
import com.yang.util.SecurityCode;
import com.yang.util.SecurityImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;


@Controller
@RequestMapping("userAction")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(String username, String passWord) {
        User uu = userService.findOne(username);
        if (uu != null && uu.getPassWord().equals(passWord)) {
            return "redirect:/Emp/findAll";
        } else {
            return "login";
        }
    }

    //注册
    @RequestMapping("regist")
    public String regist(User user) {
        userService.addOne(user);
        return "login";
    }

    //验证码
    @RequestMapping("yzm")
    public String yzm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //生成验证码的随机数
        String securityCode = SecurityCode.getSecurityCode();
        HttpSession session = request.getSession();
        session.setAttribute("securitycode", securityCode);
        //绘制生成验证码的图片
        BufferedImage createImage = SecurityImage.createImage(securityCode);
        //响应到客户端
//        HttpServletResponse response = ServletActionContext.getResponse();
        ServletOutputStream outputStream = response.getOutputStream();
        /* 第一个参数：指定验证码的图片对象
         * 第二个参数：图片得到的格式
         * 第三个参数:指定输出流
         *
         * */
        ImageIO.write(createImage, "png", outputStream);
        return null;
    }
}
