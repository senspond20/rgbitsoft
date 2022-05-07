package com.rgbitsoft.exam.design.decorator;

/**
 * 기존 뼈대(클래스)는 유지하되, 이후 필요한 형태로 꾸밀대 사용.
 * 확장이 필요한 경우 상속의 대안으로 활용한다
 * SOLID 중에서 개방폐쇄 원칙(OCP)와 의존 역전 원칙(DIP)를 따른다.
 */
public class Run {
    public static void main(String[] args) {
        ICar audi = new Audi(1000);
        audi.showPrice();

        //a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();
        //a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();
        //a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();
    }
}
