package com.codestates.jwtAuthentication1.filter;

import org.apache.catalina.filters.ExpiresFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse  response, FilterChain chain) throws IOException, ServletException{
       // System.out.println("FirstFilter");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse)  response;

        res.setCharacterEncoding("UTF-8");
        if (req.getMethod().equals("POST")) {
            String headerAuth = req.getHeader("Authorization");

            if (headerAuth.equals("codestates")) {
                chain.doFilter(req, res);
            }else {
                PrintWriter writer = res.getWriter();
                writer.println("인증실패");
            }
        }


    }
}
