package com.vincentdao.project_euler;

import com.vincentdao.project_euler.common.InputFileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem22 {

    private static final String PATH = "input/problem22.txt";

    public static void main(String[] args) {
        List<String> input = InputFileReader.readFileIntoListOfString(PATH);
        List<String> names = new ArrayList<>();
        StringTokenizer tk = new StringTokenizer(input.get(0), " ,\"");
        while (tk.hasMoreTokens()) {
            names.add(tk.nextToken());
        }
        names = names.stream().sorted().collect(Collectors.toList());
        long resultSum = 0;
        for (int namePosition = 1, nameIndex = 0; nameIndex < names.size(); namePosition++, nameIndex++) {
            long charactersSum = 0;
            String name = names.get(nameIndex);
            for (int charIndex = 0; charIndex < name.length(); charIndex++) {
                charactersSum += name.charAt(charIndex) - 'A' + 1;
            }
            resultSum += charactersSum * namePosition;
        }
        System.out.println(resultSum);
    }
}
