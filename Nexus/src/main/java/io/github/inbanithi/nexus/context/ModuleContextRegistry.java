package io.github.inbanithi.nexus.context;

import io.github.inbanithi.nexus.definition.ModuleDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ModuleContextRegistry {


    private final Map<String, ConfigurableApplicationContext> registry;


    public ModuleContextRegistry(Map<String, ConfigurableApplicationContext> registry) {
        this.registry = registry;
    }

    public ModuleContextRegistry(){
        this(new ConcurrentHashMap<>());
    }

    public void register(ModuleDefinition definition, ConfigurableApplicationContext context){
        registry.put(definition.getModuleName(), context);
    }

    public ApplicationContext getContext(String moduleName){
        return registry.get(moduleName);
    }

}
