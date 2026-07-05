package learning.tacocloud.hungnv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeHttpRequests(
                        authorize ->
                                authorize.requestMatchers("/design", "/order").hasRole("USER")
                                        .anyRequest().permitAll()
                )
                .formLogin(login -> login
                                .loginPage("/login")
                                .permitAll()
                )
                .logout(logout -> logout.logoutSuccessUrl("/"))
                .build();
    }
}
