package com.example.demo.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginUser;

@Service
public class CustomUserDetails implements UserDetails {
	
	private final LoginUser user;
	
	/**
	 * コンストラクタ
	 * @param user
	 */
	public CustomUserDetails(LoginUser user) {
		this.user = user;
	}
	
	/**
	 * ロールの取得
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	/**
	 * パスワードの取得
	 */
	@Override
	public String getPassword() {
		return this.user.getPassword();
	}
	
	/**
	 * ユーザー名の取得
	 */
	@Override
	public String getUsername() {
		return this.user.getUsername();
	}
	
	/**
	 * 店舗IDの取得
	 */
	//@Override
	public int getShopid() {
		return this.user.getShop_id();
	}
	
	public LoginUser getUser() {
        return user;
    }
	

}