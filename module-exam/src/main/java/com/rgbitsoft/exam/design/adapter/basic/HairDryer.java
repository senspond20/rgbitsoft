package com.rgbitsoft.exam.design.adapter.basic;

public class HairDryer implements Electronic110V{
    @Override
    public void powerOn() {
        System.out.println("헤어 드라이어 100V On");
    }
}