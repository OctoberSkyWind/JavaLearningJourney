package ng.hx.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:mybatisConfig.properties")
@Configuration
public class MybatisConfig {
}
