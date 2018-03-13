package com.oauth2.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.json.JSONObject;

import com.oauth2.demo.constants.OAuthConstants;
import com.oauth2.demo.utils.HttpClientUtil;

/**
 * Created by srujant on 11/7/17.
 */
public class GoogleCallBackHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = req.getParameter(OAuthConstants.CODE);

        String accessToken = getAccessToken(code, resp);
        if (accessToken == null)
            return;

        HttpGet httpGet = new HttpGet(OAuthConstants.GOOGLE_API_INFO);
        httpGet.setHeader("Authorization", "Bearer " + accessToken);
        HttpResponse googleApiInfo = HttpClientUtil.executeGet(httpGet);
        IOUtils.copy(googleApiInfo.getEntity().getContent(), resp.getOutputStream());

    }

    private String getAccessToken(String code, HttpServletResponse httpServletResponse) {
        String requestBody = new StringBuilder(OAuthConstants.CLIENT_ID).append("=").append(OAuthConstants.GOOGLE_CLIENT_ID_VALUE)
                .append("&").append(OAuthConstants.CLIENT_SECRET).append("=").append(OAuthConstants.GOOGLE_CLIENT_SECRET_VALUE)
                .append("&").append(OAuthConstants.CLIENT_ID).append("=").append(code)
                .append("&").append(OAuthConstants.REDIRECT_URI).append("=").append(OAuthConstants.REDIRECT_URI_VALUE)
                .append("&").append(OAuthConstants.GRANT_TYPE).append("=authorization_code")
                .append("&").append(OAuthConstants.STATE).append("=dev").toString();

        HttpPost httpPost = new HttpPost(OAuthConstants.GOOGLE_ACCESS_TOKEN_URL);
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(requestBody.getBytes(), ContentType.APPLICATION_FORM_URLENCODED);
        httpPost.setEntity(byteArrayEntity);
        HttpResponse httpResponse = HttpClientUtil.executePost(httpPost);
        String accessToken = null;
        try {
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                IOUtils.copy(httpResponse.getEntity().getContent(), httpServletResponse.getOutputStream());
            } else {
                String response = IOUtils.toString(httpResponse.getEntity().getContent());
                JSONObject jsonObject = new JSONObject(response);
                accessToken = (String) jsonObject.get("access_token");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return accessToken;
    }

}
