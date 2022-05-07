package com.rgbitsoft.exam.design.proxy.brower;

/**
 * Proxy Pattern - 대리인이라는 뜻으로 , 뭔가를 대신처리하는 것
 *
 * 개방폐쇄 원칙(OCP)와 의존 역전 원칙(DIP)를 따른다.
 * Cache의 기능으로 활용
 * Spring에서는 AOP
 */
public class Run {

    public static void main(String[] args) {
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        /*
        매번 받아오고 있다. (캐시미적용)
        browser loading html form : www.naver.com
        browser loading html form : www.naver.com
        browser loading html form : www.naver.com
        browser loading html form : www.naver.com
        browser loading html form : www.naver.com
         */
        System.out.println("===============================");

        IBrowser browserProxy = new BrowserProxy("www.naver.com");

        browserProxy.show();
        browserProxy.show();
        browserProxy.show();
        browserProxy.show();
        browserProxy.show();


    }
}
