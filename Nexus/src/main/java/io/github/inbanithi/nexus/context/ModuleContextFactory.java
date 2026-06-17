package io.github.inbanithi.nexus.context;

import io.github.inbanithi.nexus.definition.ModuleDefinition;
import org.springframework.context.ApplicationContext;

public interface ModuleContextFactory {

    ApplicationContext create(ModuleDefinition module, ApplicationContext parentContext);

}
