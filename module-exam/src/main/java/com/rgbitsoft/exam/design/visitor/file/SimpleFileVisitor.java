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

    // 1. 디렉터리를 처리하기 전
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        logger.debug("preVisit : {} ", dir.toString());
        return FileVisitResult.CONTINUE;
    }

    // 2. 파일을 만날 때
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        logger.debug("visitFile : {} ", file.toString());
        fileList.add(file.toFile());
//        return FileVisitResult.CONTINUE;

        String fileName = file.getFileName().toString();
        if( fileName.equals("SocketAdapter.java")){
            System.out.println( file.getParent() + " 경로에 " + fileName + "파일이 있습니다." );

            return FileVisitResult.TERMINATE;
        }else{
            return FileVisitResult.CONTINUE;
        }
    }

    // 3. visitFile 메서드에서 예외가 일어날 때
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        logger.debug("visitFileFailed : {} ", file.toString());
        return FileVisitResult.CONTINUE;
    }

    // 4. 디렉터리를 처리한 후
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        logger.debug("preVisit : {} ", dir.toString());
        return FileVisitResult.CONTINUE;
    }
}
