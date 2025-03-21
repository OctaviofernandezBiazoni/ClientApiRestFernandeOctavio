package com.clientAPIRest.demo.SwaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApi {
  
  @Bean
  public OpenAPI springShopOpenAPI() {
      return new OpenAPI()
              .info(new Info()
                      .title("Veterinaria API")
                      .description("API para gestionar citas, dueños, mascotas y peluqueros en un servicio de peluquería canina.")
                      .version("v0.0.1")
                      .license(new License().name("Apache 2.0").url("http://springdoc.org"))
              )
              .externalDocs(new ExternalDocumentation()
                      .description("Documentación Externa")
                      .url("https://github.com/OctaviofernandezBiazoni/ClientApiRestFernandeOctavio"))
              ;
  }
}
