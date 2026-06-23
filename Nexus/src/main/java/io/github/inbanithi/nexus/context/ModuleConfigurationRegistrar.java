package io.github.inbanithi.nexus.context;

import io.github.inbanithi.nexus.definition.ModuleDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public interface ModuleConfigurationRegistrar {

    void register(AnnotationConfigApplicationContext context, ModuleDefinition module);

}
