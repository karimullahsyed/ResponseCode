
package com.innoviti.quickemitab.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.innoviti.quickemitab.service.UserAuthenticationService;


@Configuration
@EnableWebSecurity
public class OAuth2SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserAuthenticationService userAuthenticationServiceImpl;
  
  @Autowired
  private DataSource dataSource;


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().anonymous().disable().authorizeRequests().antMatchers("/oauth/token/**").permitAll();
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  public TokenStore tokenStore() {
    return new JdbcTokenStore(dataSource);
  }

  @Bean
  public AuthorizationCodeServices authorizationCodeServices() {
    return new JdbcAuthorizationCodeServices(dataSource);
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userAuthenticationServiceImpl);
    authenticationProvider.setPasswordEncoder(shaPasswordEncoder());
    authenticationProvider.setSaltSource(reflectionSaltSource());
    return authenticationProvider;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(8);
  }
  
  
  @Bean
  public ReflectionSaltSource reflectionSaltSource(){
  	ReflectionSaltSource refSaltSource = new ReflectionSaltSource();
  	refSaltSource.setUserPropertyToUse("username");  	
  	return refSaltSource;
  	
  }
  
  @Bean
  public ShaPasswordEncoder shaPasswordEncoder(){
  	ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);
  	return passwordEncoder;
  }
  
  
  public static void main(String[] args) {
	  System.out.println(new BCryptPasswordEncoder(8).encode("password"));
  }
}

