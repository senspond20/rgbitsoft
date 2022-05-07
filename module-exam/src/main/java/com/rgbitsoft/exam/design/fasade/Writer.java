package com.rgbitsoft.exam.design.fasade;

public class Writer {

    private String fileName;

    public Writer(String fileName){
        this.fileName = fileName;
    }
    public void fileConnenct(){
        String format = String.format("Wirter %s 로 연결합니다", fileName);
        System.out.println(format);
    }

    public void fileWriter(){
        String format = String.format("Wirter %s 의 내용을 기록합니다", fileName);
        System.out.println(format);
    }

    public void fileDisconnect(){
        String format = String.format("Wirter %s 로 연결종료 합니다", fileName);
        System.out.println(format);
    }
}
