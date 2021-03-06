/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.broker;

import javax.jms.JMSException;

import org.apache.activemq.command.ActiveMQDestination;

/**
 * An exception thrown if a destination is attempted to be created when it already exists.
 * 
 * 
 */
public class DestinationAlreadyExistsException extends JMSException {
    private final ActiveMQDestination destination;

    public DestinationAlreadyExistsException(ActiveMQDestination destination) {
        super("Destination already exists: " + destination);
        this.destination = destination;
    }

    public ActiveMQDestination getDestination() {
        return destination;
    }
}
