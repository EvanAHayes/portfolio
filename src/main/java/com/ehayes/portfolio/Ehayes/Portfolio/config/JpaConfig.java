package com.ehayes.portfolio.Ehayes.Portfolio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {

    //configure to look up the current user
    @Bean
    public AuditorAware<String> auditorAware() {
    return new AuditorAwareImpl();
}


}
