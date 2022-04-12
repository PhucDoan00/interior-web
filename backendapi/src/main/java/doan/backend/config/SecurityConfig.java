package doan.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
    private UserDetailsService customUserDetailsService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //.antMatchers(HttpMethod.GET, "/api/**").permitAll()
                .antMatchers("/api/auth/signin").anonymous()
                .antMatchers("/api/auth/signup").anonymous()
                .antMatchers("/api/auth/signupstaff").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/products/{id}").hasRole("CUSTOMER")
                .antMatchers("/api/v1/products/**").permitAll()
                .antMatchers("/api/v1/createproduct").hasRole("STAFF")
                .antMatchers("/api/v1/editproduct/**").hasRole("STAFF")
                .antMatchers("/api/v1/deleteproduct/**").hasRole("STAFF")
                .antMatchers("/api/v1/cart/**").hasRole("CUSTOMER")
                .antMatchers("/api/v1/checkout").hasRole("CUSTOMER")
                .antMatchers("/api/v1/designidea/{id1}").permitAll()
                .antMatchers("/api/v1/designidea/{id1}/{id2}").permitAll()
                .antMatchers("/api/v1/designidea/idea/id").permitAll()
                .antMatchers("/api/v1/feedback").hasRole("CUSTOMER")
                .antMatchers("/api/v1/profile/**").authenticated()
                .antMatchers("/api/v1/viewbill/**").hasRole("CUSTOMER")
                .antMatchers("/api/v1/viewallbill/**").hasAnyRole("ADMIN", "STAFF")
                .antMatchers("/").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
             		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
             	.and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
}
