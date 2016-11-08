package net.javacafe.gaebal;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @author 임형태
 * @since 2015.10.28
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class WebMvcApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebMvcApplication.class, WebSecurityConfig.class);
    }

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();

        WebMvcApplication application = new WebMvcApplication();
        application.configure(builder);

        builder.run(args);
    }

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        /**
         * 메인 프로젝트의 경로를 Root 로 잡기 때문에
         * Intellij 의 서브 모듈의 경우 Root 경로를 별도로 설정해 주어야 하며
         * 이클립스의 경우도 다르게 설정해 주어야 한다.
         *
         * 만약 이러한 Root 설정이 어려울 경우 gradle bootRun 으로 Spring Boot 를 시작할 수 있으나 Intellij 상에서 terminate 가 안되므로
         * 별도의 Console 에서 gradle bootRun 후에 Ctrl + C 를 이용하여 Terminate 할 것을 권장한다.
         */
        return factory -> factory.setDocumentRoot(new File("gaebal-login-step2/src/main/webapp"));
    }
}