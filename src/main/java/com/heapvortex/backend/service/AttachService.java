package com.heapvortex.backend.service;

import com.heapvortex.backend.attach.AttachManager;
import com.heapvortex.backend.dto.AttachResponse;
import com.sun.tools.attach.VirtualMachine;

import org.springframework.stereotype.Service;

@Service
public class AttachService {

    public AttachResponse attach(
            String pid) {

        try {

            AttachManager manager = new AttachManager();

            VirtualMachine vm = manager.attach(pid);

            vm.detach();

            return new AttachResponse(
                    true,
                    "Successfully Attached");

        } catch (Exception e) {

            return new AttachResponse(
                    false,
                    e.getMessage());

        }

    }

}