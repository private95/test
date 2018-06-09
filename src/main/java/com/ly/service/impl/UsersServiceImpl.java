package com.ly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ly.email.MailService;
import com.ly.entity.Users;
import com.ly.entity.UsersExample;
import com.ly.entity.UsersExample.Criteria;
import com.ly.mapper.UsersMapper;
import com.ly.service.UsersService;
import com.ly.utils.HomePageResult;

@Service
public class UsersServiceImpl implements UsersService {

	
	@Autowired
	private UsersMapper usersMapper;
	
	@Autowired
	private MailService mailService;
	
	public HomePageResult login(String username,String password) {
		UsersExample example = new UsersExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<Users> list = usersMapper.selectByExample(example);
		Users users = list.get(0);
		if(username!=null && !username.isEmpty() && password!=null && !password.isEmpty()) {
			if( username==null|| username.isEmpty()) {
				return HomePageResult.build(400, "用户名空！");
			}
			if(!password.equals(users.getPassword())) {
				return HomePageResult.build(400, "密码错误！");
			}
			return HomePageResult.build(200, "登录成功！");
		}
		return HomePageResult.build(400, "请输入用户名或密码！");
	}

	@Override
	public HomePageResult getEmailVerification(String email) {
		try {
			mailService.sendSimpleMail(email, "理财百科邮箱验证码", "9527");
			return HomePageResult.build(200, "验证码发送成功!");
		} catch (Exception e) {
			return HomePageResult.build(400, "验证码发送失败!");
		}
	}
}
