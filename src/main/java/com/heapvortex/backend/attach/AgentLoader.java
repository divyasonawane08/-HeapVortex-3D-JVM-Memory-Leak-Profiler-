package com.heapvortex.backend.attach;

import com.sun.tools.attach.VirtualMachine;

public class AgentLoader {

        public void loadAgent(
                        VirtualMachine vm) throws Exception {

                String javaHome = vm.getSystemProperties()
                                .getProperty(
                                                "java.home");

                String agentPath = javaHome
                                + "/jmods";

                System.out.println(
                                "Java Home : "
                                                + javaHome);

        }

}