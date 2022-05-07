package com.rgbitsoft.exam.design.decorator;

public class A5 extends AudiDecorator{
    public A5(ICar iCar, String modelName) {
        super(iCar, modelName, 3000);
    }
}
