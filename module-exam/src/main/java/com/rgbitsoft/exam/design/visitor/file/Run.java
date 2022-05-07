package com.rgbitsoft.exam.design.visitor.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Run {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/module-exam/src/main/";

        SimpleFileVisitor sv = new SimpleFileVisitor();
        Files.walkFileTree(Path.of(filePath),sv);
        sv.getFileList().stream().forEach(System.out::println);


    }
}
