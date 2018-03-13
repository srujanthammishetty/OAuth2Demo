package com.oauth2.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by srujant on 18/7/17.
 */
public class UpdateRequestInfo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientId = req.getParameter("client_id");
        String clientSecret = req.getParameter("client_secret");
        String scope = req.getParameter("scope");
        String resourceUrl = req.getParameter("resourceUrl");

        Properties properties = new Properties();
        properties.put("clientId",clientId);
        properties.put("clientSecret",clientSecret);
        properties.put("scope",scope);
        properties.put("resourceUrl",resourceUrl);

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("resource.properties");
        properties.load(inputStream);
        properties.store(new FileOutputStream("resource.properties"),"");
    }
}
