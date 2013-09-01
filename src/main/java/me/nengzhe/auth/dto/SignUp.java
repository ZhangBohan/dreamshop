package me.nengzhe.auth.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

/**
 * User: bohan
 * Date: 9/1/13
 * Time: 8:41 PM
 */
public class SignUp {
    @Size(min = 4, max = 20)
    // Not used
    private String username;
    @Size(min = 6, max = 20)
    private String password;
    @Size(min = 6, max = 20)
    private String rePassword;

    @AssertTrue(message = "两次输入的密码不一致！")
    private boolean isValid() {
        return this.password.equals(this.rePassword);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
