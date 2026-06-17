package io.github.inbanithi.nexus.definition;

import io.github.inbanithi.nexus.annotation.Module;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ClassUtils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ImportCandidateModuleDiscovery implements ModuleDiscovery{

    private static final Class<Module> MODULE = Module.class;

    private ClassLoader loader;

    public ImportCandidateModuleDiscovery(ClassLoader loader){
        this.loader = loader;
    }

    public ImportCandidateModuleDiscovery(){

    }
    @Override
    public List<Class<?>> discoverModules(ApplicationContext parentContext) {

        if(Optional.ofNullable(loader).isEmpty()){
            loader = parentContext.getClassLoader();
        }
        ImportCandidates candidates = ImportCandidates.load(MODULE, loader);
        Set<Class<?>> discovered = new LinkedHashSet<>();
        for(String candidate : candidates.getCandidates()){
            discovered.add(loadClass(candidate));
        }
        return List.copyOf(discovered);
    }

    public Class<?> loadClass(String name){
        try {
            return ClassUtils.forName(name,loader);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
