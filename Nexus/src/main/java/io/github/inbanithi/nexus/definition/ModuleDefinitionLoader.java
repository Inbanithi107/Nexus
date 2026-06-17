package io.github.inbanithi.nexus.definition;

public interface ModuleDefinitionLoader {

    ModuleDefinition load(Class<?> moduleClass);

}
