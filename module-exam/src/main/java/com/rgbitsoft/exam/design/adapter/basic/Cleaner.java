package com.rgbitsoft.exam.design.adapter.basic;

public class Cleaner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("청소기 220v on");
    }
}
