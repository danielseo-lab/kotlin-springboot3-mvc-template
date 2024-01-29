package com.daniel.template.framework.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = ["com.daniel.template.framework.adapter.output.db"])
@EntityScan(basePackages = ["com.daniel.template.framework.adapter.output.db"])
class DatabaseConfig {
}