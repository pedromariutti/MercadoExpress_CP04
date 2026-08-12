package br.com.fiap.mercadoexpress.common;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI mercadoExpressOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mercado Express API")
                        .description("CRUD de produtos de um mercado express (Checkpoint 4 - Java Advanced)")
                        .version("v1"));
    }
}
