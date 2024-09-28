package dio.myfirstwebapi.config.documentation;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//    private Contact contact(){
//        return new Contact(
//                "Seu Nome",
//                "http://www.seusite.com.br",
//                "seusite@gmail.com"
//        );
//    }
//
//    private ApiInfoBuilder informacoesApi(){
//        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//        apiInfoBuilder.title("Title - Rest API");
//        apiInfoBuilder.description("API exemplo de uso de Spring REST API");
//        apiInfoBuilder.version("1.0");
//        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
//        apiInfoBuilder.license("Licença - Sua Empresa");
//        apiInfoBuilder.licenseUrl("http://seusite.com.br");
//        apiInfoBuilder.contact(this.contact());
//
//        return apiInfoBuilder;
//    }
//
//    @Bean
//    public Docket detalheApi(){
//        Docket docket = new Docket(DocumentationType.SWAGGER_2);
//
//        docket
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("dio.myfirstwebapi.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(this.informacoesApi().build())
//                .consumes(new HashSet<String>(List.of("application/json")))
//                .produces(new HashSet<String>(List.of("application/json")));
//
//        return docket;
//    }


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Title - Rest API")
                        .description("API exemplo de uso de Spring REST API")
                        .version("1.0")
                        .termsOfService("Termo de uso: Open Source")
                        .contact(new Contact()
                                .name("Seu Nome")
                                .url("http://www.seusite.com.br")
                                .email("seusite@gmail.com"))
                        .license(new License()
                                .name("Licença - Sua Empresa")
                                .url("http://seusite.com.br")));
    }

}
