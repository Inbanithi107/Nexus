package io.github.inbanithi.nexus.context;

import io.github.inbanithi.nexus.definition.ModuleDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationModuleConfigurationRegistrar implements ModuleConfigurationRegistrar{
    @Override
    public void register(AnnotationConfigApplicationContext context, ModuleDefinition module) {
        context.register(module.getConfiguration());
    }
}
