package com.lisa.onlineMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



//spring security是spring家族的一个安全框架
//自动装配 spring 身份验证管理器
//作用： 防止CSRF攻击
//因为spring security有自己默认的登录页

/*虽然我们在WebMvcConfigurer中设置跨域，但是如果WebSecurityConfigurerAdapter中不设置http.cors()，会导致一个的问题：
如果一个需要被spring security过滤器验证的请求，比如对url“/getInfo”的请求，如果这个请求没有通过验证，比如没有携带token或token不正确，
导致没有给该请求发放authentication，那么这个请求会在后续的Authentication过滤器中被认定鉴权失败，直接返回response给客户端。
这种情况下请求将不会交给WebMvcConfigurer的跨域过滤器，而WebMvcConfigurer的跨域过滤器会给response header中添加“Access-Control-Allow-Origin”字段，
该字段表示服务器接收此Origin的跨域请求。由于该请求不会经过WebMvcConfigurer的过滤器，因此响应头中不会携带“Access-Control-Allow-Origin”字段，
导致虽然请求正确在服务器处理了，也把响应发回给浏览器了，但是浏览器认为服务器不接受该地址的跨域请求，不会将response传递给页面脚本，
并且提示该服务器禁止此Origin的跨域请求。
*/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilter(jwtAuthorizationFilter());
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter() throws Exception {
        return new JwtAuthorizationFilter(this.authenticationManager());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
