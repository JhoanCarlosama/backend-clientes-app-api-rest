package com.bolsadeideas.springboot.backend.apirest.auth;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    // PARA OAUTH
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // para el registro de rutas se inician desde las rutas más específicas hasta las más genéricas
        http.authorizeRequests()
                // permite acceder a la url /api/clientes a cualquer usuario autenticado o no
                .antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/page/**", "/api/uploads/img/**", "/images/**").permitAll()
                /*.antMatchers("/api/clientes/{id}").permitAll()
                .antMatchers("/api/facturas/**").permitAll()*/
                // para especificar un solo rol se puede usar 'hasRole' y para varios roles 'hasAnyRole'
                /*.antMatchers(HttpMethod.GET, "/api/clientes/{id}", "api/clientes/page/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
                .antMatchers("/api/clientes/**").hasRole("ADMIN")*/
                /* siempre se coloca al final, dice que cualquier request adicional al que se configuro al
                en el antMatchers podrá accederse solo por usuarios autenticas */
                .anyRequest().authenticated()
                .and().cors().configurationSource(corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:80", "http://localhost", "https://clientes-app-angular-7cfe0.web.app"));
        config.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
