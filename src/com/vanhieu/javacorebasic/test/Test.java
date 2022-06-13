package com.vanhieu.javacorebasic.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

     void test(int a, int b, List<Integer> list) {
         System.out.println(System.identityHashCode(a));
         System.out.println(System.identityHashCode(b));
         a = 5;
         b = 6;

         System.out.println(";ldsafsl;adjfa;sldkf");
         list.add(a);
         list.add(b);
         System.out.println(list);
     }


    public static void main(String[] args) {

         int a = 1, b = 2;
        List<Integer> listA = new ArrayList<>();
        listA.add(a);
        listA.add(b);
        System.out.println(listA);
        listA.add(1);
        System.out.println("after add list");

         Test test = new Test();
         test.test(a, b, listA);
        System.out.println(listA);
        System.out.println("--------------------");


        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));

    }
}
