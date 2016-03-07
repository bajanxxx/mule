/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.extension.metadata;

import org.mule.api.metadata.MetadataKey;
import org.mule.extension.api.metadata.MetadataContext;
import org.mule.extension.api.metadata.MetadataKeysBuilder;
import org.mule.extension.api.metadata.MetadataResolver;
import org.mule.metadata.api.builder.BaseTypeBuilder;
import org.mule.metadata.api.model.BooleanType;
import org.mule.metadata.api.model.MetadataFormat;
import org.mule.metadata.api.model.MetadataType;
import org.mule.metadata.api.model.StringType;

import java.util.List;

public class NoConfigMetadataResolver implements MetadataResolver
{

    public enum KeyIds {BOOLEAN, STRING}
    public static final String BOOLEAN_TYPE_RESULT_ID = BooleanType.class.getSimpleName()+"Result";
    public static final String STRING_TYPE_RESULT_ID = StringType.class.getSimpleName()+"Result";


    public List<MetadataKey> getMetadataKeys(MetadataContext context)
    {
        return MetadataKeysBuilder.createKeys()
                .addKey(KeyIds.BOOLEAN.name())
                .addKey(KeyIds.STRING.name())
                .build();
    }

    public MetadataType getContentMetadata(MetadataContext context, MetadataKey key)
    {
        MetadataType type = BaseTypeBuilder.create(new MetadataFormat("nullType", "nullType")).nullType().build();

        if (key.getId().equals(KeyIds.BOOLEAN.name()))
        {
            type = BaseTypeBuilder.create(new MetadataFormat(KeyIds.BOOLEAN.name(), BooleanType.class.getSimpleName())).booleanType().build();
        }
        else if (key.getId().equals(KeyIds.STRING.name()))
        {
            type =  BaseTypeBuilder.create(new MetadataFormat(KeyIds.STRING.name(), StringType.class.getSimpleName())).stringType().build();
        }

        return type;
    }

    public MetadataType getOutputMetadata(MetadataContext context, MetadataKey key)
    {
        MetadataType type = BaseTypeBuilder.create(new MetadataFormat("nullType", "nullType")).nullType().build();

        if (key.getId().equals(KeyIds.BOOLEAN.name()))
        {
            type = BaseTypeBuilder.create(new MetadataFormat(KeyIds.BOOLEAN.name() + " Result", BOOLEAN_TYPE_RESULT_ID)).booleanType().build();
        }
        else if (key.getId().equals(KeyIds.STRING.name()))
        {
            type =  BaseTypeBuilder.create(new MetadataFormat(KeyIds.STRING.name() + " Result", STRING_TYPE_RESULT_ID)).stringType().build();
        }

        return type;
    }
}
