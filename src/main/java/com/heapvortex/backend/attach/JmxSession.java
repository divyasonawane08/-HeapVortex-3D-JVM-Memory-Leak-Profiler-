package com.heapvortex.backend.attach;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import java.io.IOException;

public class JmxSession {

    private final String pid;
    private final JMXConnector connector;
    private final MBeanServerConnection connection;

    public JmxSession(String pid,
            JMXConnector connector,
            MBeanServerConnection connection) {
        this.pid = pid;
        this.connector = connector;
        this.connection = connection;
    }

    public String getPid() {
        return pid;
    }

    public JMXConnector getConnector() {
        return connector;
    }

    public MBeanServerConnection getConnection() {
        return connection;
    }

    public void close() {
        if (connector != null) {
            try {
                connector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}