package com.bolsadeideas.springboot.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService usuarioService;

    @Bean
    public static BCryptPasswordEncoder passwordEnconder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEnconder());
    }

    @Bean("authenticationManager")
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // PARA SPRING
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /* siempre se coloca al final, dice que cualquier request adicional al que se configuro al
                en el antMatchers podrá accederse solo por usuarios autenticas */
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                /* deshabilitar el manejo de sesión por el lado de spring security(stateless), ya que
                se va a trabajar con token, a diferencia de cuando se trabaja con spring MVC que se debe trabajar
                con manejo de sesiones */
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
