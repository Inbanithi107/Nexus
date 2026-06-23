package io.github.inbanithi.nexus.definition;

import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModuleDefinitionBuilder {

    private final ModuleDiscovery moduleDiscovery;

    private final ConfigurableApplicationContext parentContext;

    private final ModuleDefinitionLoader moduleDefinitionLoader;

    public ModuleDefinitionBuilder(ModuleDiscovery moduleDiscovery, ConfigurableApplicationContext parentContext, ModuleDefinitionLoader moduleDefinitionLoader) {
        this.moduleDiscovery = moduleDiscovery;
        this.parentContext = parentContext;
        this.moduleDefinitionLoader = moduleDefinitionLoader;
    }

    public ModuleDefinitionBuilder(ConfigurableApplicationContext context){
        this(new ImportCandidateModuleDiscovery(), context, new AnnotationConfigModuleDefinitionLoader());
    }

    public Collection<ModuleDefinition> buildModules(){
        List<Class<?>> classes = moduleDiscovery.discoverModules(parentContext);
        List<ModuleDefinition> definitions = new ArrayList<>();
        for(Class<?> moduleClass : classes){
            ModuleDefinition definition = moduleDefinitionLoader.load(moduleClass);
            definitions.add(definition);
        }
        return definitions;
    }

}
