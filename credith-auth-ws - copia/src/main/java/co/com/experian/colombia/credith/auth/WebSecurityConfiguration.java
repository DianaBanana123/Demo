package co.com.experian.colombia.credith.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@SpringBootApplication
@EnableWebSecurity
@ComponentScan(value = "co.com.experian.colombia.credith")
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(WebSecurityConfiguration.class, args);
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	       return super.authenticationManagerBean();
	}
	
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	UserDetails user=User.builder()
    			.username("user")
    			.password(encoder.encode("secret"))
    			.roles("USER").build();    	
        return new InMemoryUserDetailsManager(user);
    }   
	

}
