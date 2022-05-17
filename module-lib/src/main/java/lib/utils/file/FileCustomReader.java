package com.rgbitsoft.core.utils.file;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * 파일 읽기
 */
public class FileCustomReader {

    private FileCustomReader() {
    }
    public static FileCustomReader getInstance() {
        return LazyHolder.INSTANCE;
    }
    private static class LazyHolder {
        private static final FileCustomReader INSTANCE = new FileCustomReader();
    }

    public static File getFile(String filePath, String fileName){
        return new File(String.valueOf(Path.of(filePath).resolve(fileName)));
    }


    public String readAll(InputStream inputStream, Charset charset) {
        String string = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            StringBuilder builder = new StringBuilder();
            while ((string = reader.readLine()) != null) {
                builder.append(string + FileConstants.LINE_SEPARATOR);
            }
            string = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    public String readAll(File file, Charset charset) throws FileNotFoundException {
        return readAll(new FileInputStream(file), charset);
    }

    /**
     *
     * @param inputStream
     */
    public List<String> read(InputStream inputStream, Charset charset){
        String string = "";
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            while ((string = reader.readLine()) != null) {
                lines.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * @param inputStream
     */
    public List<String> read(InputStream inputStream){
        return read(inputStream, FileConstants.DEFAULT_CHARSET);
    };


    /**
     * @param file
     * @param charset
     * @return
     * @throws FileNotFoundException
     */
    public List<String> read(File file, Charset charset) throws FileNotFoundException {
        return read(new FileInputStream(file), charset);
    }

    /**
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public List<String> read(File file) throws FileNotFoundException {
        return read(new FileInputStream(file),  FileConstants.DEFAULT_CHARSET);
    }

}
