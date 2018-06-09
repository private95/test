package com.ly.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ly.entity.Users;
import com.ly.service.UsersService;
import com.ly.utils.HomePageResult;

@Controller
public class UsersController {

	
	
	@Autowired
	private UsersService usersService;
	
	
	@RequestMapping("users/login")
	public ModelAndView login(String username,String password,ModelAndView mv) {
		System.out.println(username+"------"+password);
		HomePageResult result = usersService.login(username, password);
		if(result.getStatus()==200) {
			mv.setViewName("index");
			return mv;
		}else {
			mv.setViewName("login");
			return mv;
		}
	}
	
	
	@RequestMapping("users/getEmailVerification")
	@ResponseBody
	public HomePageResult getEmailVerification(@RequestParam("verification") String email) {
		System.out.println(":::::"+email);
		HomePageResult result = usersService.getEmailVerification(email);
		return result;
	}
}
