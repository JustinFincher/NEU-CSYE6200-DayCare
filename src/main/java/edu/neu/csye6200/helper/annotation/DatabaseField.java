package edu.neu.csye6200.helper.annotation;

import edu.neu.csye6200.model.DatabaseFieldType;

import javax.annotation.Nonnull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DatabaseField
{
    @Nonnull
    String fieldName();
    @Nonnull
    DatabaseFieldType fieldType();
}
