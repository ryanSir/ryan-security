package com.ryan.security.core.properties;

/**
 * @author ryan
 * @version Id: BrowserProperties, v 0.1 2022/4/13 1:24 PM ryan Exp $
 */
public class BrowserProperties {

    private String loginPage = "/login.html";


    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
