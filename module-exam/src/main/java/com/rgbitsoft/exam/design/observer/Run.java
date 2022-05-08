package com.rgbitsoft.exam.design.observer;

/**
 * 관찰자 패턴, 변화가 일어 났을때, 미리 등록된 다른 클래스에 통보해주는 패턴
 * event listener 에서 해당 패턴을 사용하고 있다
 */
public class Run {

    public static void main(String[] args) {
        Button button = new Button("버튼");

//        button.addListener(new IButtonListener() {
//            @Override
//            public void clickEvent(String event) {
//                System.out.println(event);
//            }
//        });

        button.addListener((msg)-> System.out.println(msg));

        button.click("메시지 전달 : click1");
        button.click("메시지 전달 : click2");
        button.click("메시지 전달 : click3");
        button.click("메시지 전달 : click4");
        button.click("메시지 전달 : click5");
    }
}
