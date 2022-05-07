package com.rgbitsoft.exam.design.adapter.basic;

// 220V 를 110V로 변경해주는
public class SocketAdapter implements Electronic110V{
    private  Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V){
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
