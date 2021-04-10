package ua.aleks4ay.kiyv_management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@ComponentScan("ua.aleks4ay.kiyv_management")
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/registration", "/login").anonymous()
//                .antMatchers("/", "/home", "/shop", "/shop/**", "/cart", "/logout", "/static/**", "/activate/*").permitAll()  //allow full access to all users there
//                .anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
//                .usernameParameter("login")
//                .failureUrl("/login?error=true")
                .permitAll()
//            .and()
//                .rememberMe()
//            .and()
//                .exceptionHandling()
//                .accessDeniedPage("/home")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select login, password, active from usr where login=?")
                .authoritiesByUsernameQuery("select u.login, ur.role from usr u inner join user_roles ur on u.id = ur.user_id where u.login=?");
    }


/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> users= new ArrayList<UserDetails>();
        users.add(User.withDefaultPasswordEncoder().username("admin").password("nimda").roles("USER","ADMIN").build());
        users.add(User.withDefaultPasswordEncoder().username("Spring").password("Security").roles("USER").build());
        return new InMemoryUserDetailsManager(users);
    }*/
}
