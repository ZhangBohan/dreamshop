package me.nengzhe.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUtils {
	
	/**
	 * 取得用户名
	 * 
	 * @return
	 */
	public static String getUsername() {
		UserDetails userDetails = getUserDetails();
		String username = "游客";
		if(userDetails != null) {
			username = userDetails.getUsername();
		}
		return username;
	}
	
	public static UserDetails getUserDetails() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = ((UserDetails) principal);
		}
		return userDetails;
	}
}
