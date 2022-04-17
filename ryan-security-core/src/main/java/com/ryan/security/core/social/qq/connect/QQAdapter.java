package com.ryan.security.core.social.qq.connect;

import com.ryan.security.core.social.qq.api.QQ;
import com.ryan.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author ryan
 * @version Id: QQAdapter, v 0.1 2022/4/17 7:27 PM ryan Exp $
 */
public class QQAdapter implements ApiAdapter<QQ> {

    @Override
    public boolean test(QQ qq) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues connectionValues) {

        QQUserInfo userInfo = api.getUserInfo();

        connectionValues.setDisplayName(userInfo.getNickname());
        connectionValues.setImageUrl(userInfo.getFigureurl_qq_1());
        connectionValues.setProfileUrl(null);
        connectionValues.setProviderUserId(userInfo.getOpenId());


    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    @Override
    public void updateStatus(QQ qq, String s) {

    }
}
