package io.github.inbanithi.nexus.dependency;

import io.github.inbanithi.nexus.definition.ModuleDefinition;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ModuleDependencyGraph {

    private final Map<String, ModuleNode> nodes;

    private final Map<String, Integer> inDegree;

    public ModuleDependencyGraph(Map<String, ModuleNode> nodes, Map<String, Integer> inDegree) {
        this.nodes = nodes;
        this.inDegree = inDegree;
    }

    public Collection<ModuleNode> nodes() {
        return nodes.values();
    }

    public Map<String, Integer> inDegreeMap() {
        return new HashMap<>(inDegree);
    }

    public static ModuleDependencyGraph from(Collection<ModuleDefinition> definitions) {

        Map<String, ModuleNode> nodes = new HashMap<>();

        Map<String, Integer> degree = new HashMap<>();

        for (ModuleDefinition definition : definitions) {
            nodes.put(definition.getModuleName(), new ModuleNode(definition));
            degree.put(definition.getModuleName(), 0);

        }

        for (ModuleDefinition definition : definitions) {

            ModuleNode current =
                    nodes.get(definition.getModuleName());

            for (String dependency : definition.getDependencies()) {

                ModuleNode dependencyNode = nodes.get(dependency);

                if (dependencyNode == null) {
                    throw new MissingModuleDependencyException(dependency);
                }

                current.addDependency(dependencyNode);

                degree.compute(definition.getModuleName(), (k, v) -> v + 1);

            }

        }

        return new ModuleDependencyGraph(nodes, degree);

    }



}
