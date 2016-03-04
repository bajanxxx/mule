/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.extension.internal.runtime.metadata;

import static org.mule.config.i18n.MessageFactory.createStaticMessage;
import static org.mule.util.Preconditions.checkArgument;
import org.mule.api.MuleRuntimeException;
import org.mule.extension.api.introspection.metadata.MetadataResolverFactory;
import org.mule.extension.api.metadata.MetaDataResolver;

public final class DefaultMetadataResolverFactory implements MetadataResolverFactory
{
    private final MetaDataResolver resolver;

    public DefaultMetadataResolverFactory(Class<? extends MetaDataResolver> resolverType)
    {
        checkArgument(resolverType != null, "MetaDataResolver type cannot be null");
        try
        {
            resolver = resolverType.newInstance();
        }
        catch (Exception e)
        {
            throw new MuleRuntimeException(createStaticMessage("Could not create MetaDataResolver of type " + resolverType.getName()), e);
        }
    }

    @Override
    public MetaDataResolver createResolver()
    {
        return resolver;
    }
}
