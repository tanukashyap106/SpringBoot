
package com.mycode.product.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

   // @Autowired
  //  private UserDetailsService userDetailsService;
   // @Autowired
    //private JwtRequestFilter requestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        /*http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/user/register","/user/login").permitAll();
                    request.requestMatchers(HttpMethod.GET, "/api/**").permitAll();
                    request.anyRequest().authenticated();
                })
                .oauth2ResourceServer(oauth2->oauth2.jwt(Customizer.withDefaults()));




               // .authenticationProvider(authenticationProvider())
              //  .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
             // .addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
               // .httpBasic(Customizer.withDefaults());

        return http.build();
    }*/
                http
                        .csrf(csrf -> csrf.disable())
                        .sessionManagement(session ->
                                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        )
                        .authorizeHttpRequests(request -> request
                                .requestMatchers("/user/register", "/user/login").permitAll()
                                .requestMatchers(HttpMethod.GET, "/**").permitAll()
                                .anyRequest().authenticated()
                        )
                        .oauth2ResourceServer(oauth2 ->
                                oauth2.jwt(jwt-> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
                        )
                        );

                return http.build();
            }
            /*
 private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter(){
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleReader());
        return jwtAuthenticationConverter;
 }*/
            @Bean
            public JwtAuthenticationConverter jwtAuthenticationConverter() {
                JwtAuthenticationConverter converter =
                        new JwtAuthenticationConverter();

                converter.setJwtGrantedAuthoritiesConverter(
                        new KeyCloakRoleReader()
                );

                return converter;
            }


        @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    /*@Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(userDetailsService);

        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }*/

   /* @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }*/
}
