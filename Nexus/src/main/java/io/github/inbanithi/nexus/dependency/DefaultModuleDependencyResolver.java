package io.github.inbanithi.nexus.dependency;

import io.github.inbanithi.nexus.definition.ModuleDefinition;

import java.util.Collection;

public class DefaultModuleDependencyResolver implements ModuleDependencyResolver {

    private final ModuleSorter moduleSorter;

    public DefaultModuleDependencyResolver(){
        this.moduleSorter = new TopologicalModuleSorter();
    }
    @Override
    public ModuleLoad resolve(Collection<ModuleDefinition> definitions) {
        return moduleSorter.sort(definitions);
    }
}
