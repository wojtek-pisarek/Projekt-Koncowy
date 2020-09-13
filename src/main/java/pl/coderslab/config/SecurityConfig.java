package pl.coderslab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.AbstractPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.user.SpringDataUserDetailsService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/offer/add").authenticated()
                .antMatchers("/wagon/add").authenticated()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/offer/main", true)
                .and().logout().logoutSuccessUrl("/offer/main")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT u.username, r.name as role FROM user u JOIN user_role b ON " +
                        " u.id = b.user_id JOIN role r ON r.id = b.role_id WHERE u.username = ?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new AbstractPasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return "123";
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }

            @Override
            protected byte[] encode(CharSequence charSequence, byte[] bytes) {
                return new byte[0];
            }
        };
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }
}
