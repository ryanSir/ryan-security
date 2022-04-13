package com.ryan.security.core.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ryan
 * @version Id: SecurityCoreConfig, v 0.1 2022/4/13 1:28 PM ryan Exp $
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
