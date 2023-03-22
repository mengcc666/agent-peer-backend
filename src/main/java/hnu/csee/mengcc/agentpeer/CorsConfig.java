@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/hello")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST")
            .allowedHeaders("*");
    }
}