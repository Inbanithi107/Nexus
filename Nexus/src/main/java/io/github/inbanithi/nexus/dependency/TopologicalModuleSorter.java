package io.github.inbanithi.nexus.dependency;

import io.github.inbanithi.nexus.definition.ModuleDefinition;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;

public class TopologicalModuleSorter implements ModuleSorter{
    @Override
    public ModuleLoad sort(Collection<ModuleDefinition> definitions) {
        ModuleDependencyGraph graph = ModuleDependencyGraph.from(definitions);
        Map<String, Integer> degree = graph.inDegreeMap();

        Queue<ModuleNode> queue = new ArrayDeque<>();

        OrderedModuleLoad ordered = new OrderedModuleLoad();
        for (ModuleNode node : graph.nodes()) {
            if (degree.get(node.getDefinition().getModuleName()) == 0) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {

            ModuleNode current = queue.poll();

            ordered.add(current.getDefinition());

            for (ModuleNode dependent : current.getDependents()) {

                String name = dependent.getDefinition().getModuleName();

                int remaining = degree.compute(name, (k, v) -> v-1);

                if (remaining == 0) {
                    queue.add(dependent);
                }
            }
        }

        if (ordered.size() != graph.nodes().size()) {
            throw new CircularDependencyException("Circular dependency detected");
        }

        return ordered;
    }
}
