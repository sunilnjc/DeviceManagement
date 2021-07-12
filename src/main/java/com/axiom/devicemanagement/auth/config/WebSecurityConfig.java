//package com.axiom.devicemanagement.auth.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
//
//import com.axiom.devicemanagement.auth.filter.JwtRequestFilter;
//
//@EnableWebSecurity
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private UserDetailsService myUserDetailsService;
//	@Autowired
//	private JwtRequestFilter jwtRequestFilter;
//
//	private static final String[] AUTH_WHITELIST = { "**/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs",
//			"/authenticate", "/webjars/**" };
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(myUserDetailsService);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().anyRequest()
//				.authenticated().and().httpBasic().authenticationEntryPoint(swaggerAuthenticationEntryPoint()).and()
//				.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//
//	}
//
//	@Bean
//	public BasicAuthenticationEntryPoint swaggerAuthenticationEntryPoint() {
//		BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
//		entryPoint.setRealmName("Swagger Realm");
//		return entryPoint;
//	}
//
//}