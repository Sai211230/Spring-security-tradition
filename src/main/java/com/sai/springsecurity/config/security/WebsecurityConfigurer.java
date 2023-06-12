package com.sai.springsecurity.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

/**
 * @author SAI
 * @create 2023-05-31
 */
@Slf4j
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true) // 开启注解鉴权
public class WebsecurityConfigurer extends WebSecurityConfigurerAdapter {

    static {
        log.info("初始化SecurityContextHolder多线程策略......");
        SecurityContextHolder.setStrategyName("MODE_INHERITABLETHREADLOCAL");
    }

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


    // 前后分离
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/login").permitAll()// 放行资源写在anyRequest之前
                .anyRequest().authenticated() // 任何请求都需要认证
                .and()
                .formLogin()// 开启表单形式的认证
                .successHandler(new CustomAuthenticationSuccessHandler())// 认证成功处理
                .failureHandler(new CustomAuthenticationFailureHandler())// 认证失败处理
                .and()
                .logout()
                .logoutRequestMatcher(new OrRequestMatcher(
                        new AntPathRequestMatcher("/logout", "GET"),
                        new AntPathRequestMatcher("**/logout", "GET")
                )) // 可匹配多个注销路径
                .invalidateHttpSession(true) // 清除session 默认 true
                .clearAuthentication(true) // 清除登录信息 默认 true
                .logoutSuccessHandler(new CustomLogoutSuccessHandler()) // 注销成功处理
                .and()
                .csrf().disable(); // 关闭csrf

    }
}
