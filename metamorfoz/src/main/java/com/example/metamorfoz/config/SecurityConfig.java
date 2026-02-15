package com.example.metamorfoz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        // 1. HERKESE AÇIK OLAN YERLER (Ana sayfa, iletişim, resimler, css)
                        .requestMatchers("/", "/iletisim", "/iletisim-gonder", "/css/**", "/js/**", "/images/**").permitAll()
                        // 2. DİĞER HER YER (Özellikle /panel) ŞİFRE İSTER
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")        // Kendi sayfamızı kullan
                        .defaultSuccessUrl("/panel") // Giriş başarılıysa direkt panele git
                        .permitAll()
                )
                .logout((logout) -> logout
                        .permitAll()
                        .logoutSuccessUrl("/") // Çıkış yapınca ana sayfaya dön
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // BURADA KULLANICI ADI VE ŞİFRE BELİRLİYORUZ
        UserDetails admin = User.withDefaultPasswordEncoder() // Şimdilik basit şifreleme
                .username("yucel")  // Kullanıcı Adın
                .password("123456") // Şifren
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }
}