package io.github.inbanithi.nexus.definition;

import io.github.inbanithi.nexus.annotation.Module;
import io.github.inbanithi.nexus.utils.ModuleNameUtils;

public class AnnotationConfigModuleDefinitionLoader implements ModuleDefinitionLoader {

    private static final Class<Module> annotation = Module.class;
    @Override
    public ModuleDefinition load(Class<?> moduleClass) {
        Module module = moduleClass.getAnnotation(annotation);
        ModuleDefinition definition = new ModuleDefinition();
        String moduleName = module.name();
        if(moduleName.equals(ModuleNameUtils.NO_MODULE_NAME)){
            moduleName = moduleClass.getSimpleName().toLowerCase();
        }
        definition.setModuleName(moduleName);
        definition.setConfiguration(module.configuration());
        definition.setDependencies(module.dependsOn());

        return definition;
    }


}
