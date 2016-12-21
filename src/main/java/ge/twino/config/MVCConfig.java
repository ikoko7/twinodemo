package ge.twino.config;
/**
 * Created by SHEMO on 12/21/2016.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/users").setViewName("users");
        registry.addViewController("/userProfile").setViewName("userProfile");
        registry.addViewController("/saveUser").setViewName("saveUser");
        registry.addViewController("/").setViewName("index");

    }
}
