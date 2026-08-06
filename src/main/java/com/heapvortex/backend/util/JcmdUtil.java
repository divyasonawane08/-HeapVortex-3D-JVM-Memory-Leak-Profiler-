package com.heapvortex.backend.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JcmdUtil {

    public static String execute(String command) throws Exception {

        Process process = Runtime.getRuntime().exec(command);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        StringBuilder output = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();

        return output.toString();
    }
}