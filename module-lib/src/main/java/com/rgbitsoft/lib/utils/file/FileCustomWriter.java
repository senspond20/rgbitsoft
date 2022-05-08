package com.rgbitsoft.lib.utils.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 파일 쓰기
 */
public class FileCustomWriter {

    private FileCustomWriter() {
    }
    public static FileCustomWriter getInstance() {
        return FileCustomWriter.LazyHolder.INSTANCE;
    }
    private static class LazyHolder {
        private static final FileCustomWriter INSTANCE = new FileCustomWriter();
    }

    public boolean write(File file, String data, Charset charset, boolean isAppend) throws IOException {
        boolean isSucess = false;

        try(
                FileWriter fw = new FileWriter(file, charset, isAppend);
                BufferedWriter bw = new BufferedWriter(fw);
        )
        {
            bw.write(data); //버퍼에 데이터 입력
            bw.flush(); //버퍼의 내용을 파일에 쓰기
            bw.close();
            isSucess = true;
        }catch ( IOException e ) {
            throw new IOException("파일 저장에 실패하였습니다.");
        }
        return isSucess;
    }

    public boolean write(File file, String data) throws IOException {
        return write(file, data, FileConstants.DEFAULT_CHARSET, true);
    }
    public boolean write(File file, List<String> data) throws IOException {
        return write(file, data,  FileConstants.DEFAULT_CHARSET, true);
    }

    public boolean write(File file, List<String> data, Charset charset, boolean isAppend) throws IOException {
        boolean isSucess = false;

        try(
                FileWriter fw = new FileWriter(file, charset, isAppend);
                BufferedWriter bw = new BufferedWriter(fw);
        )
        {
            for (String str : data){
                bw.write(str);; //버퍼에 데이터 입력
                bw.flush(); //버퍼의 내용을 파일에 쓰기
            }
            bw.close();
            isSucess = true;
        }catch ( IOException e ) {
            throw new IOException("파일 저장에 실패하였습니다.");
        }
        return isSucess;
    }


}
