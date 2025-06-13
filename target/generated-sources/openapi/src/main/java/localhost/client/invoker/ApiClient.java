/*
 * Spring Security 6+ APP
 * Spring Boot 3+ Spring Security 6+ example
 *
 * The version of the OpenAPI document: 0.0.1-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package localhost.client.invoker;

import localhost.client.api.*;

import io.restassured.builder.RequestSpecBuilder;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static localhost.client.invoker.JacksonObjectMapper.jackson;

public class ApiClient {
    public static final String BASE_URI = "http://localhost:8086";

    private final Config config;

    private ApiClient(Config config) {
        this.config = config;
    }

    public static ApiClient api(Config config) {
        return new ApiClient(config);
    }

    public AuthenticationApi authentication() {
        return AuthenticationApi.authentication(config.reqSpecSupplier);
    }
    public AuthorizationApi authorization() {
        return AuthorizationApi.authorization(config.reqSpecSupplier);
    }

    public static class Config {
        private Supplier<RequestSpecBuilder> reqSpecSupplier = () -> new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(jackson())));

        /**
         * Use common specification for all operations
         * @param supplier supplier
         * @return configuration
         */
        public Config reqSpecSupplier(Supplier<RequestSpecBuilder> supplier) {
            this.reqSpecSupplier = supplier;
            return this;
        }

        public static Config apiConfig() {
            return new Config();
        }
    }
}