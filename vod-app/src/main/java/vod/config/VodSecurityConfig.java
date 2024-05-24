package vod.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class VodSecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder() {return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    UserDetailsService userDetailsService(DataSource dataSource) {
//        UserDetails user1 = User
//                .withUsername("user1")
//                .password("user1")
//                .roles("ADMIN")
//                .build();
//        UserDetails user2 = User
//                .withUsername("user2")
//                .password("user2")
//                .roles("REGULAR")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
        userDetailsManager.setDataSource(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select username, password, 'true' from user where username = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select username, role from role where username = ?");
        return userDetailsManager;
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests(req -> req
                        .requestMatchers(HttpMethod.POST, "/webapi/games").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "webapi/museums").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "webapi/museums/**").authenticated()
                        .anyRequest().permitAll()
                )
                .httpBasic()
                .and().build();
    }
}
