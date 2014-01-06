package com.jolbox.bonecp.config;

import com.jolbox.bonecp.xsd.DefaultConfigType;
import com.jolbox.bonecp.xsd.PropertyNameType;
import com.jolbox.bonecp.xsd.PropertyType;

import java.lang.reflect.Field;

public class DefaultConfigTypeBuilder extends AbstractBoneCPConfigTypeBuilder<DefaultConfigType, DefaultConfigTypeBuilder> {

    public static DefaultConfigTypeBuilder aBoneCPDefaultConfig() {
        return new DefaultConfigTypeBuilder();
    }

    @Override
    public DefaultConfigType build() {
        DefaultConfigType type = new DefaultConfigType();
        for (Field field : declaredFields()) {
            PropertyType property = new PropertyType();
            property.setName(PropertyNameType.fromValue(field.getName()));
            try {
                property.setValue(String.valueOf(field.get(this)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            type.getProperty().add(property);
        }
        return type;
    }
}
