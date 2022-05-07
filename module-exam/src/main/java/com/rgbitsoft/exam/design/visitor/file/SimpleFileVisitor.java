package com.rgbitsoft.exam.design.visitor.file;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class SimpleFileVisitor implements FileVisitor<Path> {

    private Logger logger = LoggerFactory.getLogger(SimpleFileVisitor.class);

    private List<File> fileList = new LinkedList<>();

    public List<File> getFileList() {
        return fileList;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        logger.debug("preVisit : {} ", dir.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        logger.debug("visitFile : {} ", file.toString());
        fileList.add(file.toFile());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        logger.debug("visitFileFailed : {} ", file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        logger.debug("preVisit : {} ", dir.toString());
        return FileVisitResult.CONTINUE;
    }
}
