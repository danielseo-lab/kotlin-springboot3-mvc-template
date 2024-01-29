package com.daniel.template.framework.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonSupportConfig {

    /**
     * Jackson은 kotlin에서 아래와 같이 설정해야 오류가 없다.
     */
    @Bean
    fun objectMapper() = ObjectMapper()
        .registerModules(JavaTimeModule())
        .registerKotlinModule()
}