package com.infoshareacademy.zieloni.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class ChangeEncoding
 */

@WebFilter(
        filterName = "ChangeEncoding",
        urlPatterns = {"/*"})

public class ChangeEncoding implements Filter {


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}