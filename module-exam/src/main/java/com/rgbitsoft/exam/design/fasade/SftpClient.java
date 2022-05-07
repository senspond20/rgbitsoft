package com.rgbitsoft.exam.design.fasade;

public class SftpClient {
    private Ftp ftp;
    private Reader reader;
    private Writer writer;

    public SftpClient(Ftp ftp, Reader reader, Writer writer){
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    public SftpClient(String host, int port, String path, String fileName){
        this.ftp = new Ftp(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }

    public void connect(){
        ftp.connect();
        ftp.moveDictory();
        writer.fileConnenct();
        reader.fileConnenct();
    }
    public void disconnect(){
        writer.fileDisconnect();
        reader.fileDisconnect();
        ftp.disConnenct();
    }

    public void read(){
        reader.fileRead();
    }

    public void write(){
        writer.fileWriter();
    }


}
