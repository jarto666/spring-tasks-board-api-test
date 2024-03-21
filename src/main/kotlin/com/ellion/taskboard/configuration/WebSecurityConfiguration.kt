package com.ellion.taskboard.configuration

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity


@Configuration
class WebSecurityConfiguration {

    @Bean
    @Throws
    fun configure(http: HttpSecurity) = ApplicationRunner {
        http.authorizeHttpRequests { it.anyRequest().authenticated()}
        http.oauth2ResourceServer {it.jwt {  }}
    }
}