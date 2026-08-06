package com.heapvortex.backend.service;

import com.heapvortex.backend.model.JvmProcess;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JvmProcessService {

    public List<JvmProcess> getRunningProcesses() {

        List<JvmProcess> list = new ArrayList<>();

        for (VirtualMachineDescriptor vm : VirtualMachine.list()) {

            String name = vm.displayName();

            if (name == null || name.isBlank()) {
                name = "Unknown Java Process";
            }

            list.add(new JvmProcess(vm.id(), name));
        }

        return list;
    }
}