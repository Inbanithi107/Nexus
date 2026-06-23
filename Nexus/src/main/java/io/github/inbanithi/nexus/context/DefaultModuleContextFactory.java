package io.github.inbanithi.nexus.context;

import io.github.inbanithi.nexus.definition.ModuleDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class DefaultModuleContextFactory implements ModuleContextFactory{

    private final ModuleContextBuilder moduleContextBuilder;

    private final ModuleContextInitializer moduleContextInitializer;

    private final ModuleContextRegistry moduleContextRegistry;

    public DefaultModuleContextFactory(ModuleContextBuilder moduleContextBuilder, ModuleContextInitializer moduleContextInitializer, ModuleContextRegistry moduleContextRegistry) {
        this.moduleContextBuilder = moduleContextBuilder;
        this.moduleContextInitializer = moduleContextInitializer;
        this.moduleContextRegistry = moduleContextRegistry;
    }

    public DefaultModuleContextFactory(){
        this.moduleContextBuilder = new SpringModuleContextBuilder();
        this.moduleContextRegistry = new ModuleContextRegistry();
        this.moduleContextInitializer = new ModuleContextInitializer();
    }

    @Override
    public ConfigurableApplicationContext create(ModuleDefinition module, ConfigurableApplicationContext parentContext) {
        GenericApplicationContext context = moduleContextBuilder.build(module);
        moduleContextInitializer.initialize(context, module, parentContext);
        moduleContextRegistry.register(module, context);
        return context;
    }
}
