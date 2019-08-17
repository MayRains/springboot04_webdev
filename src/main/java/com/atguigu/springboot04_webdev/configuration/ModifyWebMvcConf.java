package com.atguigu.springboot04_webdev.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class ModifyWebMvcConf implements WebMvcConfigurer {
    /*
    default void addViewControllers(ViewControllerRegistry registry) {
	}
	how to rewrite an interface:
	-implement the interface || if the abstract class use the extends
	-iterate the methods and find out the method that needs override
	-ctrl + the method iterate the functions
	*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        // it means that client sends the 'goLogin' request and browser responses with 'login.html'
        // registry.addViewController("/goLogin").setStatusCode(HttpStatus.valueOf(201)).setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new modifyLocaleResolver() {
        };
    }
    private static class modifyLocaleResolver implements LocaleResolver{

        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String localeStr = request.getParameter("language");
            Locale localeInfo = Locale.getDefault();
            if (!StringUtils.isEmpty(localeStr)){
                System.out.println(localeStr);
                String[] split = localeStr.split("_");
                localeInfo = new Locale(split[0],split[1]);
            }
            return localeInfo;
        }

        @Override
        public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        }
    }





    }



