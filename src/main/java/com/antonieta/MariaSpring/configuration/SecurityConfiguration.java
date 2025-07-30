package com.antonieta.MariaSpring.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//crea el constructor con lombok
@RequiredArgsConstructor
public class SecurityConfiguration {

    //metodo para encriptar contraseñas
    //@Bean un objeto para gestionar
    @Bean
    public PasswordEncoder passwordEncoder(){
        //Nos ayuda a encriptar nuestra password comparandola encriptada
        return new BCryptPasswordEncoder();

    }
    @Bean
    /*
     * Esta anotación se utiliza a nivel de método.
     * La anotación @Bean funciona con @Configuration
     * para crear beans Spring. Como se mencionó anteriormente,
     * @Configuration tendrá métodos para crear instancias y configurar
     * dependencias. Dichos métodos serán anotados con @Bean.
     * El método anotado con esta anotación funciona como la ID del bean,
     * y crea y devuelve el bean real.
     * */

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(
                auth ->auth
                        // ** para permitir todas las rutas que pide la api
                        .requestMatchers("/api/**").permitAll()
                        //Filtrar las peticiones
                        .anyRequest().permitAll()

                //cross safe frequest for   indica al navegador que las peticiones son confiables qu eestan pasando por un host conocido
                //similar al cors(cross origin site) capas de seguridad para la web

        ).csrf(csrf ->csrf.disable());
        return httpSecurity.build();

    }


}