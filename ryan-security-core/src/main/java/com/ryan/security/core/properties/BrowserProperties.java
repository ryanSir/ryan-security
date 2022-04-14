package com.ryan.security.core.properties;

/**
 * @author ryan
 * @version Id: BrowserProperties, v 0.1 2022/4/13 1:24 PM ryan Exp $
 */
public class BrowserProperties {

    private String loginPage = "/login.html";

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSeconds = 3600;


    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }
    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    /**
     * Getter method for property <tt>rememberMeSeconds</tt>.
     *
     * @return property value of rememberMeSeconds
     */
    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    /**
     * Setter method for property <tt>rememberMeSeconds</tt>.
     *
     * @param rememberMeSeconds value to be assigned to property rememberMeSeconds
     */
    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
