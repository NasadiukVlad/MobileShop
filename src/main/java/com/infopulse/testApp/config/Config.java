package com.infopulse.testApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Влад on 21.11.2015.
 */
@Configuration
@Import(value = {ConfigDao.class, ConfigService.class})
public class Config {
}
