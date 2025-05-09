package main.java.parciales1;

import main.java.tp3.ejercicio1.GeneralTree;

public class Test13 {

    public static void main(String[] args) {

        GeneralTree<Integer> a2 = new GeneralTree<>(2);
        GeneralTree<Integer> a7 = new GeneralTree<>(7);
        GeneralTree<Integer> a5 = new GeneralTree<>(5);
        GeneralTree<Integer> a22 = new GeneralTree<>(22);
        GeneralTree<Integer> a2_2 = new GeneralTree<>(2);
        GeneralTree<Integer> a6 = new GeneralTree<>(6);
        GeneralTree<Integer> a9 = new GeneralTree<>(9);
        GeneralTree<Integer> a20 = new GeneralTree<>(20);
        GeneralTree<Integer> a1 = new GeneralTree<>(1);
        GeneralTree<Integer> a3 = new GeneralTree<>(3);
        GeneralTree<Integer> a1_1 = new GeneralTree<>(1);
        GeneralTree<Integer> a4 = new GeneralTree<>(4);
        GeneralTree<Integer> a8 = new GeneralTree<>(8);
        GeneralTree<Integer> a22_2 = new GeneralTree<>(22);
        GeneralTree<Integer> a9_2 = new GeneralTree<>(9);

        a2.addChild(a7);
        a2.addChild(a5);
        a2.addChild(a22);

        a7.addChild(a2_2);
        a7.addChild(a6);

        a5.addChild(a9);

        a22.addChild(a20);
        a22.addChild(a1);

        a6.addChild(a3);
        a6.addChild(a1_1);

        a9.addChild(a4);

        a1.addChild(a8);
        a1.addChild(a22_2);
        a1.addChild(a9_2);


        Parcial13 p = new Parcial13();

        Integer mayor = p.mayor(a2);
        System.out.println(mayor);


    }


}
