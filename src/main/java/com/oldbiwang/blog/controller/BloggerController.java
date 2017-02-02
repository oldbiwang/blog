package com.oldbiwang.blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oldbiwang.blog.pojo.Blogger;
import com.oldbiwang.blog.service.BloggerService;
import com.oldbiwang.blog.util.CryptographyUtil;

/**
 * @Description 博主Controller层，前台部分，不需要认证
 * @author oldbiwang
 *
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {
	
	@Resource
	private BloggerService bloggerService;
	
	@RequestMapping("/login")
	public String login(Blogger blogger, HttpServletRequest request) {
		
		Subject subject = SecurityUtils.getSubject(); //获取当前登陆的主体
		String newPassword = CryptographyUtil.md5(blogger.getPassword(), "oldbiwang");//将密码使用md5加密
		//将用户信息封装到token中
		UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUsername(), newPassword);
		System.out.println("subject=======>" + subject);
		try {
			subject.login(token);
			System.out.println("continue");
 			//会调用MyRealm中的doGetAuthenticationInfo方法进行身份认证
			return "admin/main";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			request.setAttribute("errorInfo", "用户名或密码错误");
			System.out.println("login error");
			return "login";
		} 

	}
}