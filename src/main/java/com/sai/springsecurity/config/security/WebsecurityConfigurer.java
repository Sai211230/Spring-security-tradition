package com.sai.springsecurity.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author SAI
 * @create 2023-05-31
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true) // 开启注解鉴权
public class WebsecurityConfigurer extends WebSecurityConfigurerAdapter {

//    public String getJsonStringFromRequest(HttpServletRequest request) throws IOException {
//        StringBuffer sb = new StringBuffer();
//        InputStream is = request.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
//        String s = "";
//        while ((s = br.readLine()) != null) {
//            sb.append(s);
//        }
//        String str = sb.toString();
//        return str;
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/index/**").permitAll()// 放行资源写在anyRequest之前
                .mvcMatchers("/login").permitAll()// 放行资源写在anyRequest之前
                .anyRequest().authenticated() // 任何请求都需要认证
                .and()
                .formLogin()// 开启表单形式的认证
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .usernameParameter("username")
                .passwordParameter("password")
                .successForwardUrl("/index")// forward不会跳转到之前请求的路径
//                .defaultSuccessUrl("/index")// redirect 重定向 如果之前有请求的路径，会优先跳转之前的路径
                .failureUrl("/login")
                .and()
                .csrf().disable();
    }
}
