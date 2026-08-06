package com.heapvortex.backend.service;

import com.heapvortex.backend.model.JvmProcess;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalJvmService {

    public List<JvmProcess> getRunningJvms() {

        List<JvmProcess> list = new ArrayList<>();

        for (VirtualMachineDescriptor vm : VirtualMachine.list()) {

            String pid = vm.id();
            String name = vm.displayName();

            if (name == null || name.isBlank()) {
                name = "Unknown JVM";
            }

            list.add(new JvmProcess(pid, name));
        }

        return list;
    }
}