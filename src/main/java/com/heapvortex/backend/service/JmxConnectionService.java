package com.heapvortex.backend.service;

import com.sun.tools.attach.VirtualMachine;
import org.springframework.stereotype.Service;

@Service
public class JmxConnectionService {

    public String connect(String pid) {

        try {

            VirtualMachine vm = VirtualMachine.attach(pid);

            String agent = vm.getSystemProperties().getProperty("java.home")
                    + "/lib/management-agent.jar";

            try {
                vm.loadAgent(agent);
            } catch (Exception ignored) {
                // Agent may already be loaded
            }

            String connectorAddress = vm.getAgentProperties().getProperty(
                    "com.sun.management.jmxremote.localConnectorAddress");

            vm.detach();

            return connectorAddress;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }

    }

}