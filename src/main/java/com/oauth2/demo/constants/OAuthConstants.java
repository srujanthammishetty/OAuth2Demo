package com.oauth2.demo.constants;

/**
 * Created by srujant on 11/7/17.
 */
public class OAuthConstants {

    public static final String ACCESS_TOKEN = "access_token";
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_SECRET = "client_secret";
    public static final String CODE = "code";
    public static final String REDIRECT_URI = "redirect_uri";
    public static final String GRANT_TYPE = "grant_type";
    public static final String RESPONSE_TYPE = "response_type";
    public static final String STATE = "state";
    public static final String SCOPE = "scope";


    public static String REDIRECT_URI_VALUE = "http://localhost:8080/OAuth/callback";


    public static String GOOGLE_CLIENT_ID_VALUE = "{GoogleClientId}";
    public static String GOOGLE_CLIENT_SECRET_VALUE = "{GoogleClientSecret}";

    public static final String GOOGLE_AUTHORIZATION_URL = "https://accounts.google.com/o/oauth2/auth";
    public static final String GOOGLE_ACCESS_TOKEN_URL = "https://www.googleapis.com/oauth2/v3/token";
    public static String SCOPE_VALUE = "https://www.googleapis.com/auth/plus.login%20https://www.googleapis.com/auth/calendar%20https://www.googleapis.com/auth/userinfo.email";
    public static final String GOOGLE_API_INFO = "https://www.googleapis.com/plus/v1/people/me";


    public static final String FACEBOOK_AUTHORIZATION_URL = "https://www.facebook.com/2.5/dialog/oauth";
    public static final String FACEBOOK_ACCESS_TOKEN_URL = "https://graph.facebook.com/v/2.5/oauth/access_token";
    public static String FB_REDIRECT_URI = "http://localhost:8080/oauth/callback";
    public static String FB_SCOPE = "public_profile";
    public static final String FB_RESOURCE_URL = "https://graph.facebook.com/me?fields=id,name,picture";

    public static final String FB_CLIENT_ID = "{facebook_Client_ID}";
    public static final String FB_CLIENT_SECRET = "{facebook_Client_Secret}";

    public static final String LINKEDIN_AUTHORIZATION_URL = "https://www.linkedin.com/uas/oauth2/authorization";
    public static final String LINKEDIN_ACCESS_TOKEN_URL = "https://www.linkedin.com/uas/oauth2/accessToken";


}
