package com.oauth2.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oauth2.demo.config.OAuthUserConfig;
import com.oauth2.demo.constants.OAuthConstants;

/**
 * Created by srujant on 11/7/17.
 */
public class OAuth2AuthorizationHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String url = new StringBuilder(OAuthConstants.GOOGLE_AUTHORIZATION_URL).append("?client_id=")
                .append(OAuthUserConfig.GOOGLE_CLIENT_ID_VALUE)
                .append("&").append(OAuthConstants.REDIRECT_URI).append("=").append(OAuthConstants.REDIRECT_URI_VALUE)
                .append("&").append(OAuthConstants.SCOPE).append("=").append(OAuthConstants.SCOPE_VALUE)
                .append("&").append(OAuthConstants.RESPONSE_TYPE).append("=code")
                .append("&").append(OAuthConstants.STATE).append("=dev").toString();
        httpServletResponse.sendRedirect(url);
    }

}
