package com.ryan.security.core.auth.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author ryan
 * @version Id: SmsCodeAuthenticationProvider, v 0.1 2022/4/15 10:09 AM ryan Exp $
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;
        UserDetails user = userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());
        if (user == null){
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }
        SmsCodeAuthenticationToken authenticationTokenResult = new SmsCodeAuthenticationToken(user,user.getAuthorities());
        authenticationTokenResult.setDetails(authenticationToken.getDetails());

        return authenticationTokenResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }

    /**
     * Getter method for property <tt>userDetailsService</tt>.
     *
     * @return property value of userDetailsService
     */
    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    /**
     * Setter method for property <tt>userDetailsService</tt>.
     *
     * @param userDetailsService value to be assigned to property userDetailsService
     */
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
