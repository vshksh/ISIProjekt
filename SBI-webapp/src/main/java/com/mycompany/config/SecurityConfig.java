package com.mycompany.config;
 
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 
 * Konfiguracja Spring Security, czyli zarządzania logowaniem i autoryzacją.
 * 
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/sbi");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("");
	    return driverManagerDataSource;
	}
    
    
        //Tworenie beana dataSource, żeby użyć loginu i hasła z bazy
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(  //  Pobranie uzytkownika
			"select login, haslo, 1 from konta where login=?")
		.authoritiesByUsernameQuery(    //  I jego roli (uprawnien)
			"select login, rola from konta where login=?");
	}	
	
        //  Konfiguracja
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ADMIN')")//  Do tego strony ma dostęp tylko admin
		.and()
		  .formLogin().failureUrl("/login?error")
                  .defaultSuccessUrl("/zalogowano")
		  .usernameParameter("login").passwordParameter("haslo")
		.and()
                 .logout()
                  .logoutUrl("/logout") 
		  .logoutSuccessUrl("/")
                  .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.and()
		  .exceptionHandling().accessDeniedPage("/403")
		.and()
		  .csrf();
	}
        
}