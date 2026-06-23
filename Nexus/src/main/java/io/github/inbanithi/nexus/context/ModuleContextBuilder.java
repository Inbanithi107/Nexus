package io.github.inbanithi.nexus.context;

import io.github.inbanithi.nexus.definition.ModuleDefinition;
import org.springframework.context.support.GenericApplicationContext;

public interface ModuleContextBuilder {

    GenericApplicationContext build(ModuleDefinition module);

}
