package io.github.inbanithi.nexus.context;

import io.github.inbanithi.nexus.definition.ModuleDefinition;
import org.springframework.context.ConfigurableApplicationContext;

public interface ModuleContextFactory {

    ConfigurableApplicationContext create(ModuleDefinition module, ConfigurableApplicationContext parentContext);

}
