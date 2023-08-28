package com.vincentdao.project_euler.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

    private InputFileReader() {
    }

    public static List<String> readFileIntoListOfString(String filePath) {
        try (InputStream is = ClassLoader.getSystemResourceAsStream(filePath)) {
            assert is != null;
            List<String> result = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    result.add(line);
                }
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Can't read input file");
        }
    }
}
