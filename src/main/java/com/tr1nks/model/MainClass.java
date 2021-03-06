package com.tr1nks.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Точка входа
 * так же здесь описаны пакеты для поиска {@link org.springframework.stereotype.Component Component}
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({
        "com.tr1nks.config",
        "com.tr1nks.controller",
        "com.tr1nks.model.services",
        "com.tr1nks.model.utils",
        "com.tr1nks.model.engines",
        "com.tr1nks.model.formatters",
})
public class MainClass extends SpringBootServletInitializer {
    public static final Class[] classes = {MainClass.class,};
    public static ApplicationContext ac;

    /**
     * Точка входа
     *
     * @param args аргументы
     */
    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "true");
        System.setProperty("spring.thymeleaf.cache", "false");
        ac = SpringApplication.run(classes, args);
    }

    /**
     * {@inheritDoc}
     *
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(classes);
    }
}
/*
//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext context) {
//        return args -> {
//            System.out.println("INSPECT BEANS:");
//            String[] beanNames = context.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//        };
//    }
}
*/