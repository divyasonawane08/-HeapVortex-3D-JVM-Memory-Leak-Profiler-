package com.heapvortex.backend.attach;

import com.sun.tools.attach.VirtualMachine;
import org.springframework.stereotype.Component;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Properties;

@Component
public class JmxConnectionManager {

    private JmxSession currentSession;

    public synchronized JmxSession connect(String pid) throws Exception {

        // Disconnect any existing session
        disconnect();

        VirtualMachine vm = null;

        try {

            // Attach to target JVM
            vm = VirtualMachine.attach(pid);

            // Read agent properties
            Properties agentProps = vm.getAgentProperties();

            // Check if local JMX connector already exists
            String connectorAddress = agentProps.getProperty("com.sun.management.jmxremote.localConnectorAddress");

            // If not, start the local management agent
            if (connectorAddress == null || connectorAddress.isBlank()) {

                System.out.println("Starting Local JMX Management Agent...");

                connectorAddress = vm.startLocalManagementAgent();

                if (connectorAddress == null || connectorAddress.isBlank()) {

                    throw new RuntimeException(
                            "Unable to start Local JMX Management Agent for PID: " + pid);
                }
            }

            System.out.println("JMX Connector Address : " + connectorAddress);

            // Connect to JMX
            JMXServiceURL serviceURL = new JMXServiceURL(connectorAddress);

            JMXConnector connector = JMXConnectorFactory.connect(serviceURL);

            MBeanServerConnection connection = connector.getMBeanServerConnection();

            currentSession = new JmxSession(
                    pid,
                    connector,
                    connection);

            System.out.println("Connected successfully to JVM PID : " + pid);

            return currentSession;

        } finally {

            if (vm != null) {
                vm.detach();
            }
        }
    }

    public synchronized boolean isConnected() {
        return currentSession != null;
    }

    public synchronized JmxSession getCurrentSession() {
        return currentSession;
    }

    public synchronized void disconnect() {

        if (currentSession != null) {

            try {
                currentSession.close();
            } catch (Exception ignored) {
            }

            currentSession = null;
        }
    }
}