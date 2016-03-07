/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.extension.internal.runtime.metadata;

import org.mule.api.connection.ConnectionException;
import org.mule.api.connector.ConnectionManager;
import org.mule.extension.api.metadata.MetadataContext;
import org.mule.extension.api.runtime.ConfigurationInstance;

import java.util.Optional;

public class DefaultMetadataContext implements MetadataContext
{

    private final ConfigurationInstance<?> configInstance;
    private final ConnectionManager connectionManager;

    public DefaultMetadataContext(ConfigurationInstance<Object> configInstance, ConnectionManager connectionManager)
    {
        this.configInstance = configInstance;
        this.connectionManager = connectionManager;
    }

    @Override
    public <C> C getConfig()
    {
        return (C) configInstance.getValue();
    }

    @Override
    public <C> Optional<C> getConnection()
    {
        try
        {
            return Optional.of((C)connectionManager.getConnection(configInstance.getValue()).getConnection());
        }
        catch (ConnectionException e)
        {

            return Optional.empty();
        }
    }

}
