package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class DemoApplication {


	@RequestMapping("/index")
	String home(HttpServletRequest request, HttpServletResponse response){
		int count=0;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for (Cookie var:cookies) {
				if(var.getName().equals("count")){
					count=Integer.parseInt(var.getValue())+1;
				}
			}
		}

		Cookie cookie=new Cookie("count",count+"");
		String userName="jiage";

		response.addCookie(cookie);

		if(count>5){
			return "您已经登陆太多次了，等会在登陆吧！";
		}

		return "欢迎您" + userName + "，这是您的第 " + count + " 次登录";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
