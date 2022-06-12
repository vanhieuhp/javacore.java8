package com.vanhieu.javacorebasic.learnclass;

public class InterfaceTestImpl implements InterfaceTest{
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
