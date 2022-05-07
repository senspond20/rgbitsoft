package com.rgbitsoft.exam.design.proxy.brower;

public class Browser implements IBrowser{
    private String url;

    public Browser(String url){
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("browser loading html form : " + url);
        return new Html(url);
    }
}
