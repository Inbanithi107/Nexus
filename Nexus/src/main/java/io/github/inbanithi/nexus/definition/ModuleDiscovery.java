package io.github.inbanithi.nexus.definition;

import org.springframework.context.ApplicationContext;

import java.util.List;

public interface ModuleDiscovery {

    List<Class<?>> discoverModules(ApplicationContext parentContext);

}
