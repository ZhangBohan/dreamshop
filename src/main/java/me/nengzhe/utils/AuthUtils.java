package me.nengzhe.utils;

import me.nengzhe.auth.dto.UserWithDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUtils {
	
	public static UserWithDetails getUserDetails() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
        UserWithDetails userWithDetails = null;
		if (principal instanceof UserDetails) {
            userWithDetails = ((UserWithDetails) principal);
		}
		return userWithDetails;
	}
}
