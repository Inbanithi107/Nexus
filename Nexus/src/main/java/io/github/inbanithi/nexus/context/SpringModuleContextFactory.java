package io.github.inbanithi.nexus.context;

import io.github.inbanithi.nexus.definition.ModuleDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringModuleContextFactory implements ModuleContextFactory{
    @Override
    public ApplicationContext create(ModuleDefinition module, ApplicationContext parentContext) {
        return new GenericApplicationContext();
    }
}
