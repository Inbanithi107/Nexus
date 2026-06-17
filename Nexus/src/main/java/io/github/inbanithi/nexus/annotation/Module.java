package io.github.inbanithi.nexus.annotation;

import io.github.inbanithi.nexus.utils.ModuleNameUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Module {

    String name() default ModuleNameUtils.NO_MODULE_NAME;

    Class<?> configuration();

    String[] dependsOn();

}
