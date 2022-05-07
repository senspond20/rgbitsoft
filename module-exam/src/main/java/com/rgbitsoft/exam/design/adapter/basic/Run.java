package com.rgbitsoft.exam.design.adapter.basic;

/**
 * Adapter Pattern
 * 호환성이 없는 기존 클래스의 인터페이스를 변환하여 재사용 할 수 있도록 한다
 * SOLID 중에서 개방폐쇄 원칙(OCP)를 따른다
 */
public class Run {

    // 콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }

    public static void main(String[] args) {
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        //connect(cleaner); // 220V 제품을 110V에 바로 꽂을 수 없다.

        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);
        
        // 자기자신을 변화시키지 않고 인터페이스의 상태를 맞춰주는 디자인 패턴
    }
}
