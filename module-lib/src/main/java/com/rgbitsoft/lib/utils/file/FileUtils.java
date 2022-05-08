package com.rgbitsoft.lib.utils.file;

import org.mozilla.universalchardet.UniversalDetector;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;

public class FileUtils {

    /**
     * LazyHolder Singleton
     */
    private FileUtils() {
    }

    public static FileUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final FileUtils INSTANCE = new FileUtils();
    }

    public FileCustomReader getReader() {
        return FileCustomReader.getInstance();
    }

    public FileCustomWriter getWriter() {
        return FileCustomWriter.getInstance();
    }

    public Resource getResource(String path){
        return new DefaultResourceLoader().getResource(path);
    }

    /**
     * 파일 경로와 파일명으로 파일 객체를 반환한다.
     */
    public File getFile(String filePath, String fileName){
        return new File(String.valueOf(Path.of(filePath).resolve(fileName)));
    }

    /**
     * 파일 확장자를 추출한다.
     */
    public String getExtFromFileName(String fileName){
        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
                .toLowerCase();
    }

    /**
     * 디렉토리 경로가 존재하는지 검사하고 없으면 폴더들을 생성한다.
     */
    public String isExistsCheckAndMkdirs(File file){
        if(!file.exists()){
            file.mkdirs();
        }
        return file.toPath().toString();
    }

    /**
     *  디렉토리 경로에 파일이 존재하는지 검사하고 없으면 파일을 생성
     */
    public File isExistsCheckAndMakeFile(File file) throws IOException {
        if(file !=null && !file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new IOException("잘못된 파일 경로입니다 -> 파일 생성 실패");
            }
        }
        return file;
    }


    public InputStream getFileInputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }


    /**
     * @apiNote  file의 Charset을 알아온다. - 라이브러리 의존성 com.googlecode.juniversalchardet
     * @param file
     * @return
     * @throws IOException
     */
    public Charset getFileEncoding(File file) throws IOException {
        Charset charset = null;
        byte[] buf = new byte[4096];
        try (
                FileInputStream fis = new FileInputStream(file);
        ){
            UniversalDetector detector = new UniversalDetector(null);
            int nread;
            while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
                detector.handleData(buf, 0, nread);
            }
            detector.dataEnd();
            String encoding = detector.getDetectedCharset();
            if (encoding != null) {
                charset = Charset.forName(encoding);
            }else {
                throw new RuntimeException("Chaset Find Fail!!");
            }
            detector.reset();
            fis.close();
        }catch(IOException e){
            throw new IOException(e.getMessage());
        }
        return charset;
    }

}
