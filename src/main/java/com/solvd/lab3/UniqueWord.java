package com.solvd.lab3;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueWord {

    public static void main(String args[]){
        try {
            //Using FileUtils
            usingFileUtils();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void usingFileUtils() throws IOException {
        // get the file object
        File file = new File("src/main/java/Test.txt");

        try {
            List<String> contents = FileUtils.readLines(file, "UTF-8");
            Set<String> uniqueCount = new HashSet<>();

            // Lambda expression
            contents.stream()
                    .map(line -> StringUtils.split(line, "[\\s,\\.]+"))
                    .flatMap(Arrays::stream)
                    .forEach(uniqueCount::add);

            System.out.println("Unique Words: " + uniqueCount.size());

            // Write the result to a file
            File result = new File("temp.txt");
            FileUtils.writeStringToFile(result, String.valueOf(uniqueCount.size()), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
