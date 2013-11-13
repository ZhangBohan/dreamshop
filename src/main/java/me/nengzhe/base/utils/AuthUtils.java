package me.nengzhe.base.utils;

import me.nengzhe.auth.dto.UserWithDetails;
import me.nengzhe.auth.model.User;
import me.nengzhe.base.exception.NotLoginException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUtils {

    public static User getUser() throws NotLoginException {
        return getUserDetails().getUser();
    }
	
	public static UserWithDetails getUserDetails() throws NotLoginException {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
        if(principal == null || principal.equals("anonymousUser")) {
            throw new NotLoginException();
        }
        UserWithDetails userWithDetails = null;
		if (principal instanceof UserDetails) {
            userWithDetails = ((UserWithDetails) principal);
		}
		return userWithDetails;
	}
}
