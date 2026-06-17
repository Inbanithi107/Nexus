package io.github.inbanithi.nexus.dependency;

import io.github.inbanithi.nexus.definition.ModuleDefinition;

import java.util.Collection;

public interface ModuleSorter {

    ModuleLoad sort(Collection<ModuleDefinition> moduleDefinitions);

}
