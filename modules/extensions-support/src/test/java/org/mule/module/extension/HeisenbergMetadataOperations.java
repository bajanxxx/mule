/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.extension;

import org.mule.extension.api.ExtensionManager;
import org.mule.extension.api.annotation.metadata.MetadataScope;
import org.mule.extension.api.annotation.param.Connection;
import org.mule.extension.api.annotation.param.metadata.Content;
import org.mule.extension.api.annotation.param.metadata.MetadataKeyParam;
import org.mule.module.extension.metadata.ConnectionAwareMetadataResolver;
import org.mule.module.extension.metadata.NoConfigMetadataResolver;

import java.util.Map;

import javax.inject.Inject;

public class HeisenbergMetadataOperations
{

    private static final String SECRET_PACKAGE = "secretPackage";
    private static final String CONTENT_TYPE = "contentType";
    private static final String METH = "meth";
    public static final String CURE_CANCER_MESSAGE = "Can't help you, you are going to die";
    public static final String CALL_GUS_MESSAGE = "You are not allowed to speak with gus.";

    @Inject
    private ExtensionManager extensionManager;

    @MetadataScope(NoConfigMetadataResolver.class)
    public void dynamicContentWithKey(@MetadataKeyParam String type, @Content Map<String, Object> payload)
    {
        //TODO
    }

    @MetadataScope(ConnectionAwareMetadataResolver.class)
    public void configAwareDynamicContentWithKey(@Connection HeisenbergConnection connection, @MetadataKeyParam String type, @Content Map<String, Object> payload)
    {
        //TODO
    }

}
