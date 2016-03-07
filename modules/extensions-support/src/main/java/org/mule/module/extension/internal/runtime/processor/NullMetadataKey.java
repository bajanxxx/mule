/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.extension.internal.runtime.processor;


import org.mule.api.metadata.MetadataKey;

import java.util.Map;
import java.util.Optional;

public class NullMetadataKey implements MetadataKey
{

    @Override
    public String getId()
    {
        return null;
    }

    @Override
    public String getDescription()
    {
        return null;
    }

    @Override
    public Optional<String> getProperty(String propertyId)
    {
        return null;
    }

    @Override
    public Map<String, String> getProperties()
    {
        return null;
    }
}
