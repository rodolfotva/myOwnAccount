package com.tva.myownaccount.configuration;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

//extends WebSecurityConfigurerAdapter {
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new UserDetailsServiceImpl();
//	}
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService());
//		authProvider.setPasswordEncoder(passwordEncoder());
//		return authProvider;
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) {
//		auth.authenticationProvider(authenticationProvider());
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//
//				.authorizeRequests().antMatchers("/en/accountmain").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
//
//				.and().authorizeRequests().antMatchers("/en/login", "/resource/**").permitAll()
//
//				.and().formLogin().loginPage("/en/login").usernameParameter("username").passwordParameter("password").permitAll()
//
//				.loginProcessingUrl("/en/postLogin").successForwardUrl("/en/#").failureUrl("/en/login").permitAll()
//
//				.and().logout().logoutUrl("/en/doLogout").logoutSuccessUrl("/en/postLogin/out").permitAll()
//
//				.and().csrf().disable();
//	}

}
