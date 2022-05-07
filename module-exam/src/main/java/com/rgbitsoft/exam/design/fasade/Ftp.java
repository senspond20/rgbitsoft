package com.rgbitsoft.exam.design.fasade;

public class Ftp {
    private String host;
    private int port;
    private String path;
    
    public Ftp(String host, int port, String path){
        this.host = host;
        this.port = port;
        this.path = path;
    }
    
    public void connect(){
        System.out.println("FTP Host : " + host + " Port :" + port + "로 연결합니다");   
    }
    public void moveDictory(){
        System.out.println("path : " + path + "로 이동 합니다.");
    }
    public void disConnenct(){
        System.out.println("FTP 연결을 종료합니다");
    }
}
