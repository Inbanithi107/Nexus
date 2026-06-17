package io.github.inbanithi.nexus.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public final class NexusApplication {

    public void run(Class<?> application, String[] args){
        ConfigurableApplicationContext Parentcontext = SpringApplication.run(application, args);

    }

}
