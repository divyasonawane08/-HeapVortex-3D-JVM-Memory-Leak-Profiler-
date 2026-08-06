package com.heapvortex.backend.attach;

import com.sun.tools.attach.VirtualMachine;

public class AttachManager {

    public VirtualMachine attach(
            String pid) throws Exception {

        return VirtualMachine.attach(pid);

    }

    public void detach(
            VirtualMachine vm) throws Exception {

        vm.detach();

    }

}