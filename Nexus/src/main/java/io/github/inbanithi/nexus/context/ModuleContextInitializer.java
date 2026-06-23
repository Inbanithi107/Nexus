package io.github.inbanithi.nexus.context;

import io.github.inbanithi.nexus.definition.ModuleDefinition;
import org.springframework.context.ConfigurableApplicationContext;

public class ModuleContextInitializer {

    public void initialize(ConfigurableApplicationContext context, ModuleDefinition moduleDefinition,  ConfigurableApplicationContext parentContext){
        context.setParent(parentContext);
        context.setId("module: "+moduleDefinition.getModuleName());
    }

}
