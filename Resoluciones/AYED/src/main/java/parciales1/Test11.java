package main.java.parciales1;

import main.java.tp3.ejercicio1.GeneralTree;

import java.util.List;

public class Test11 {

    public static void main(String[] args) {

        GeneralTree<Integer> a8 = new GeneralTree<>(8);
        GeneralTree<Integer> a3 = new GeneralTree<>(3);
        GeneralTree<Integer> a5 = new GeneralTree<>(5);
        GeneralTree<Integer> a4 = new GeneralTree<>(4);
        GeneralTree<Integer> a7 = new GeneralTree<>(7);
        GeneralTree<Integer> a6 = new GeneralTree<>(6);
        GeneralTree<Integer> a2 = new GeneralTree<>(2);
        GeneralTree<Integer> a1 = new GeneralTree<>(1);
        GeneralTree<Integer> a9 = new GeneralTree<>(9);
        GeneralTree<Integer> a10= new GeneralTree<>(10);

        a8.addChild(a3);
        a8.addChild(a5);

        a3.addChild(a4);
        a3.addChild(a7);
        a3.addChild(a6);

        a5.addChild(a1);
        a5.addChild(a9);
        a5.addChild(a10);

        a7.addChild(a2);


        ParcialArbol11 arbol11 = new ParcialArbol11();
        arbol11.tree =a8;
        List<Integer> res  = arbol11.caminoMasLargo();
        System.out.println(res);
    }
}
