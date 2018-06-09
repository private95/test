package com.ly.service;

import com.ly.utils.HomePageResult;

public interface UsersService {
	
	public HomePageResult login(String username,String password);

	
	/**
	 * 发送验证码
	 */
	public HomePageResult getEmailVerification(String email);
}
