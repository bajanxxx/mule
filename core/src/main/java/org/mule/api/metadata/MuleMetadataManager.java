/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.api.metadata;

import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.context.MuleContextAware;
import org.mule.api.processor.MessageProcessor;
import org.mule.construct.Flow;
import org.mule.metadata.api.model.MetadataType;

import java.util.List;
import java.util.Optional;

public class MuleMetadataManager implements MetadataManager, MuleContextAware
{
    private MuleContext muleContext;

    @Override
    public Optional<List<MetadataKey>> getMetadataKeys(Object event, ProcessorId processorId)
    {
        MessageProcessor messageProcessor = findMessageProcessor(processorId);
        if (MetadataAware.class.isAssignableFrom(messageProcessor.getClass())){
            try
            {
                return ((MetadataAware)messageProcessor).getMetadataKeys((MuleEvent) event);
            }
            catch (MuleException e)
            {
                throw new MetadataResolvingException(e);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<MetadataType> getContentMetadata(Object event, ProcessorId processorId, MetadataKey key)
    {
        MessageProcessor messageProcessor = findMessageProcessor(processorId);
        if (MetadataAware.class.isAssignableFrom(messageProcessor.getClass())){
            try
            {
                return ((MetadataAware)messageProcessor).getContentMetadata((MuleEvent) event, key);
            }
            catch (MuleException e)
            {
                throw new MetadataResolvingException(e);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<MetadataType> getOutputMetadata(Object event, ProcessorId processorId, MetadataKey key)
    {
        MessageProcessor messageProcessor = findMessageProcessor(processorId);
        if (MetadataAware.class.isAssignableFrom(messageProcessor.getClass()))
        {
            try
            {
                return ((MetadataAware)messageProcessor).getOutputMetadata((MuleEvent) event, key);
            }
            catch (MuleException e)
            {
                throw new MetadataResolvingException(e);
            }
        }

        return Optional.empty();
    }

    @Override
    public void setMuleContext(MuleContext context)
    {
        this.muleContext = context;
    }

    private MessageProcessor findMessageProcessor(ProcessorId processorId)
    {
        Flow flow = (Flow) muleContext.getRegistry().lookupFlowConstruct(processorId.getFlowName());
        return flow.getMessageProcessors().get(processorId.getProcessorIndex());
    }
}
