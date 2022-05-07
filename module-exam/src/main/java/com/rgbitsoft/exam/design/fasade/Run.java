package com.rgbitsoft.exam.design.fasade;

public class Run {
    public static void main(String[] args) {
        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDictory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnenct();
        writer.fileWriter();

        Reader reader = new Reader("text.tmp");
        reader.fileConnenct();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnenct();


        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22 , "/home/etc", "text.tmp");
        sftpClient.connect();

        sftpClient.write();

        sftpClient.read();

        sftpClient.disconnect();
    }
}
