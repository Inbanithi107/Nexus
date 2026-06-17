package io.github.inbanithi.nexus.dependency;

import io.github.inbanithi.nexus.definition.ModuleDefinition;

import java.util.ArrayList;
import java.util.List;

public class OrderedModuleLoad implements ModuleLoad{

    List<ModuleDefinition> definitions;

    public void setDefinitions(List<ModuleDefinition> definitions) {
        this.definitions = definitions;
    }

    public OrderedModuleLoad(List<ModuleDefinition> definitions){
        this.definitions = definitions;
    }

    public OrderedModuleLoad(){
        definitions = new ArrayList<>();
    }

    @Override
    public List<ModuleDefinition> getModules() {
        return definitions;
    }

    public void add(ModuleDefinition definition){
        definitions.add(definition);
    }

    public int size(){
        return definitions.size();
    }
}
