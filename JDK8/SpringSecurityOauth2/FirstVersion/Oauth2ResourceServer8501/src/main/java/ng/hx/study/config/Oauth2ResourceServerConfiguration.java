package ng.hx.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;


@Configuration
@EnableResourceServer
public class Oauth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String CHECK_TOKEN_URL = "http://localhost:8500/oauth/check_token";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {

        RemoteTokenServices tokenService = new RemoteTokenServices();

        tokenService.setCheckTokenEndpointUrl(CHECK_TOKEN_URL);
        tokenService.setClientId("cms");
        tokenService.setClientSecret("secret");

        resources.tokenServices(tokenService);
    }

}
