package com.rgbitsoft.exam.design.observer;

public class Button {
    private String name;
    private IButtonListener buttonListener;

//    public Button(IButtonListener iButtonListener){
//        this.buttonListener = iButtonListener;
//    }
    public Button(String name){
        this.name = name;
    }

    public void click(String message){
        this.buttonListener.clickEvent(message);
    }

    public void addListener(IButtonListener buttonListener){
        this.buttonListener = buttonListener;
    }

    public void removeListener(){
        this.buttonListener = null;
    }
}
