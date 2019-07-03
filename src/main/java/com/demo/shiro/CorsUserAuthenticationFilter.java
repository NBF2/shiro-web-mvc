package com.demo.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

public class CorsUserAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    public boolean onPreHandle(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, Object mappedValue) throws Exception {
        return super.onPreHandle(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            return super.onAccessDenied(request, response);
        } {
            HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return false;
    }
}
