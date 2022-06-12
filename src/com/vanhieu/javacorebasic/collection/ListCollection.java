package com.vanhieu.javacorebasic.collection;

import java.util.Arrays;
import java.util.List;

public class ListCollection {

    public static void main(String[] args) {

        ListCollection listCollection = new ListCollection();
        List<String> characterOfName = Arrays.asList("f", "r", "u", "i", "t");

    }

    public void showList(List<String> list) {
        list.forEach(character -> {
            System.out.print(character + " ");
        });
        System.out.println();
    }
}
