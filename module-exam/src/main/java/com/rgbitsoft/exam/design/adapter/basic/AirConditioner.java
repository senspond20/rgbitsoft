package com.rgbitsoft.exam.design.adapter.basic;

public class AirConditioner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("에어컨 200V on");
    }
}
