package io.github.inbanithi.nexus.definition;

public class ModuleDefinition {

    private String moduleName;

    private String[] dependencies;

    private Class<?> configuration;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String[] getDependencies() {
        return dependencies;
    }

    public void setDependencies(String[] dependencies) {
        this.dependencies = dependencies;
    }

    public Class<?> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Class<?> configuration) {
        this.configuration = configuration;
    }

    public ModuleDefinition(String moduleName, String[] dependencies, Class<?> configuration) {
        this.moduleName = moduleName;
        this.dependencies = dependencies;
        this.configuration = configuration;
    }

    public ModuleDefinition(){

    }
}
