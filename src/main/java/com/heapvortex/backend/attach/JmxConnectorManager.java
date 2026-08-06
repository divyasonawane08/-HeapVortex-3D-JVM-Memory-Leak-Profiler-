package com.heapvortex.backend.attach;

import com.sun.tools.attach.VirtualMachine;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import java.util.Properties;

public class JmxConnectorManager {

    public JmxSession connect(String pid) throws Exception {

        // Attach to target JVM
        VirtualMachine vm = VirtualMachine.attach(pid);

        // Read agent properties
        Properties agentProps = vm.getAgentProperties();

        String connectorAddress = agentProps.getProperty(
                "com.sun.management.jmxremote.localConnectorAddress");

        // Start the local management agent if not already running
        if (connectorAddress == null) {

            connectorAddress = vm.startLocalManagementAgent();

            if (connectorAddress == null || connectorAddress.isBlank()) {
                vm.detach();
                throw new RuntimeException(
                        "Unable to start Local JMX Management Agent.");
            }
        }

        // Create JMX connection
        JMXServiceURL serviceURL = new JMXServiceURL(connectorAddress);

        JMXConnector connector = JMXConnectorFactory.connect(serviceURL);

        MBeanServerConnection connection = connector.getMBeanServerConnection();

        vm.detach();

        return new JmxSession(
                pid,
                connector,
                connector.getMBeanServerConnection());
    }
}