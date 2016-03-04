/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.api.metadata;

import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.extension.api.metadata.MetaDataKey;
import org.mule.metadata.api.model.MetadataType;

import java.util.List;

public interface MetadataAware
{
    List<MetaDataKey> getMetadataKeys(MuleEvent event) throws MuleException;

    MetadataType getContentMetadata(MuleEvent event, MetaDataKey key) throws MuleException;

    MetadataType getOutputMetadata(MuleEvent event, MetaDataKey key) throws MuleException;
}

