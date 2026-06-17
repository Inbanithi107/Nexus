package io.github.inbanithi.nexus.dependency;

import io.github.inbanithi.nexus.definition.ModuleDefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModuleNode {

    private ModuleDefinition definition;

    private List<ModuleNode> dependsOn;

    private List<ModuleNode> dependents;

    public ModuleNode(ModuleDefinition definition, List<ModuleNode> dependsOn, List<ModuleNode> dependents) {
        this.definition = definition;
        this.dependsOn = dependsOn;
        this.dependents = dependents;
    }

    public ModuleNode(){
        this.dependsOn = new ArrayList<>();
        this.dependents = new ArrayList<>();
    }

    public ModuleNode(ModuleDefinition definition){
        this.definition = definition;
        this.dependsOn = new ArrayList<>();
        this.dependents = new ArrayList<>();
    }

    public ModuleDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(ModuleDefinition definition) {
        this.definition = definition;
    }

    public List<ModuleNode> getDependsOn() {
        return Collections.unmodifiableList(dependsOn);
    }

    public void setDependsOn(List<ModuleNode> dependsOn) {
        this.dependsOn = dependsOn;
    }

    public List<ModuleNode> getDependents() {
        return Collections.unmodifiableList(dependents);
    }

    public void setDependents(List<ModuleNode> dependents) {
        this.dependents = dependents;
    }

    public void addDependent(ModuleNode node){
        dependents.add(node);
    }

    public void addDependency(ModuleNode node){
        dependsOn.add(node);
        node.addDependent(this);
    }
}
