package com.ruoyi.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:JPA/spring-demo-cfg.xml"})
public class JpaConfig {
}
