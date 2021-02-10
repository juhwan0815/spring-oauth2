package spring.study.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("testClientId")
                .secret("{noop}testSecret")
                .redirectUris("http://localhost:8081/oauth2/callback") // 인증완료 후 이동할 클라이언트 웹 페이지 주소
                .authorizedGrantTypes("authorization_code") // 인증방식
                .scopes("read","wirte")  // Access token으로 접근할 수 있는 리소스의 범위
                .accessTokenValiditySeconds(30000); // 발급된 Access Token의 유효시간 (초)
    }
}
