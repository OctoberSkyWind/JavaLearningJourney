package ng.hx.study.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:mybatisConfig.properties")
@Configuration
@MapperScan(basePackages = {"ng.hx.study.mapper"})
public class MybatisConfig {
}
