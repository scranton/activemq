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
package org.apache.activemq.network;

import junit.framework.TestCase;
import org.apache.activemq.broker.BrokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetworkConnectionsTest extends TestCase {
    private static final Logger LOG = LoggerFactory.getLogger(NetworkConnectionsTest.class);

    private static final String LOCAL_BROKER_TRANSPORT_URI = "tcp://localhost:61616";
    private static final String REMOTE_BROKER_TRANSPORT_URI = "tcp://localhost:61617";

    public void testIsStarted() throws Exception {
        BrokerService localBroker = new BrokerService();
        localBroker.setBrokerName("LocalBroker");
        localBroker.setUseJmx(false);
        localBroker.setPersistent(false);
        localBroker.setTransportConnectorURIs(new String[]{LOCAL_BROKER_TRANSPORT_URI});
        localBroker.start();

        BrokerService remoteBroker = new BrokerService();
        remoteBroker.setBrokerName("RemoteBroker");
        remoteBroker.setUseJmx(false);
        remoteBroker.setPersistent(false);
        remoteBroker.setTransportConnectorURIs(new String[]{REMOTE_BROKER_TRANSPORT_URI});
        remoteBroker.start();

        NetworkConnector nc = localBroker.addNetworkConnector("static:(" + REMOTE_BROKER_TRANSPORT_URI + ")");
        nc.setName("NC1");

        nc.start();

        assertTrue(nc.isStarted());

        nc.stop();

        assertFalse(nc.isStarted());

        nc.start();

        assertTrue(nc.isStarted());
    }
}
