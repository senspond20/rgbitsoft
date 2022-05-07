package com.rgbitsoft.exam.design.fasade;

public class Reader {

    private String fileName;

    public Reader(String fileName){
        this.fileName = fileName;
    }
    public void fileConnenct(){
        String format = String.format("Reader %s 로 연결합니다", fileName);
        System.out.println(format);
    }

    public void fileRead(){
        String format = String.format("Reader %s 의 내용을 읽어옵니다", fileName);
        System.out.println(format);
    }

    public void fileDisconnect(){
        String format = String.format("Reader %s 로 연결종료 합니다", fileName);
        System.out.println(format);
    }
}
