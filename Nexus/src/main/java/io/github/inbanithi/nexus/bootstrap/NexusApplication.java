package io.github.inbanithi.nexus.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public final class NexusApplication {

    public void run(Class<?> application, String[] args){
        ConfigurableApplicationContext parentContext = SpringApplication.run(application, args);
        ModuleBootstrapper bootstrapper = new ModuleBootstrapper(parentContext);
        bootstrapper.bootstrap();
    }

    public void run(SpringApplication application, Class<?> app, String[] args){
        ConfigurableApplicationContext parentContext = application.run(app, args);
        ModuleBootstrapper bootstrapper = new ModuleBootstrapper(parentContext);
        bootstrapper.bootstrap();
    }

}
