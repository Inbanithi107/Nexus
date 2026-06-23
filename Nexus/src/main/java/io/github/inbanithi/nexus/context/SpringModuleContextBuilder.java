package io.github.inbanithi.nexus.context;

import io.github.inbanithi.nexus.definition.ModuleDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringModuleContextBuilder implements ModuleContextBuilder{
    @Override
    public GenericApplicationContext build(ModuleDefinition module) {
        return new AnnotationConfigApplicationContext();
    }
}
