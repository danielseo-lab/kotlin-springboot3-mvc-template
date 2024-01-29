package com.daniel.template.framekwork

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableAutoConfiguration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = ["com.daniel.template.framework.adapter.output.db"])
@EntityScan(basePackages = ["com.daniel.template.framework.adapter.output.db"])
@SpringBootConfiguration
class TestConfig {
}