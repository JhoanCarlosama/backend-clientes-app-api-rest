package com.bolsadeideas.springboot.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @Autowired
    private InfoAdicionalToken infoAdicionalToken;

    @Override
    // se confguran los permisos de nuestras rutas de acceso (endpoints) pero de spring securiry ouath2
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        /* con 'permiteAll' se da acceso a cualquier usuario puede ser anónimo o no
        para poder autenticarse en el endpoinrt /oauth/token  -> genera el token */
        security.tokenKeyAccess("permiteAll()")
                //verifica el token y su firma '/oauth/check_token
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    // configuran los clientes que van a acceder al servidor
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // corresponde al username de la aplicacion (cliente)
                .withClient("angularapp")
                // contraseña con que se dara acceso al cliente
                .secret(passwordEncoder.encode("12345"))
                // permisos que tendrá el cliente
                .scopes("read", "write")
                /* es el tipo de concesión que tendrá la aplicación(como se obtiene el token)
                'password' se usan credenciales, si los usuarios existen en el sistema backend
                y para autenticar requiere username y password, también esta authorization_code
                se autentica a través de un código de autorización que nos entrega el backend,
                un redireccionamiento a través de ese código se obtiene el token de acceso */
                .authorizedGrantTypes("password", "refresh_token")
                // configura la validez y tiempo que tardará en caducar el token
                .accessTokenValiditySeconds(3600)
                // tiempo de expiración del refresh token
                .refreshTokenValiditySeconds(3600);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // se adiciona esta nueva instancia para obtener la información adicional
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken, accessTokenConverter()));

        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter())
                .tokenEnhancer(tokenEnhancerChain);
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(JwtConfig.LLAVE_SECRETA);
        /* -- INICIO verificación para RSA y comprobacion con certificados ssl */
        /*jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVADA);
        jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLICA);*/
        /* -- FIN verificación para RSA y comprobacion con certificados ssl */
        return jwtAccessTokenConverter;
    }
}
