package io.github.inbanithi.nexus.bootstrap;

import io.github.inbanithi.nexus.context.DefaultModuleContextFactory;
import io.github.inbanithi.nexus.context.ModuleContextFactory;
import io.github.inbanithi.nexus.definition.ModuleDefinition;
import io.github.inbanithi.nexus.definition.ModuleDefinitionBuilder;
import io.github.inbanithi.nexus.definition.ModuleDiscovery;
import io.github.inbanithi.nexus.dependency.DefaultModuleDependencyResolver;
import io.github.inbanithi.nexus.dependency.ModuleDependencyResolver;
import io.github.inbanithi.nexus.dependency.ModuleLoad;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collection;
import java.util.List;

public class ModuleBootstrapper {

    private final ModuleDefinitionBuilder builder;

    private final ConfigurableApplicationContext parentContext;

    private final ModuleDependencyResolver resolver;

    private final ModuleContextFactory contextFactory;

    public ModuleBootstrapper(ConfigurableApplicationContext parentContext) {
        builder = new ModuleDefinitionBuilder(parentContext);
        this.parentContext = parentContext;
        this.resolver = new DefaultModuleDependencyResolver();
        this.contextFactory = new DefaultModuleContextFactory();
    }

    public void bootstrap(){

        Collection<ModuleDefinition> definitions = builder.buildModules();
        ModuleLoad moduleLoad = resolver.resolve(definitions);
        for(ModuleDefinition definition : moduleLoad.getModules()){
            contextFactory.create(definition, parentContext);
        }
    }

}
