package com.rgbitsoft.exam.design.signleton;

import junit.framework.TestCase;

class SocketClient{
    private static SocketClient socketClient;
    // 기본 생성자 금지
    private SocketClient(){}

    //https://javaplant.tistory.com/21 참고
    public static SocketClient getInstance(){
        if(socketClient == null){  // 1번 : 쓰레드가 동시 접근시 문제
            socketClient = new SocketClient();  // 2번 : 쓰레드가 동시 접근시 인스턴스 여러번 생성
        }
        return socketClient;
    }
    public void connect(){
        System.out.println("connect");
    }
}

class AClass{
    private SocketClient socketClient;
    public AClass(){
        this.socketClient = SocketClient.getInstance();
    }
    public SocketClient getSocketClient() {
        return socketClient;
    }
}

class BClass{
    private SocketClient socketClient;
    public BClass(){
        this.socketClient = SocketClient.getInstance();
    }
    public SocketClient getSocketClient() {
        return socketClient;
    }
}

public class BasicSingleton extends TestCase {
    public static void main(String[] args) {
        AClass aClass = new AClass();
        BClass bClass = new BClass();

        System.out.println(aClass.equals(bClass));
        //assertEquals(aClass, bClass);

        SocketClient aClient = aClass.getSocketClient();
        SocketClient bClient = aClass.getSocketClient();

        System.out.println(aClient.equals(bClient));
        assertEquals(aClient, bClient);
    }
}
