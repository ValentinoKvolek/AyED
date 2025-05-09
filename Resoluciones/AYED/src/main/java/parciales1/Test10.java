package main.java.parciales1;

import main.java.tp3.ejercicio1.GeneralTree;

import java.util.List;

public class Test10 {

    public static void main(String[] args) {

        // Crear nodos
        GeneralTree<Integer> a2 = new GeneralTree<>(2);
        GeneralTree<Integer> a1 = new GeneralTree<>(1);
        GeneralTree<Integer> a12 = new GeneralTree<>(12);
        GeneralTree<Integer> a14 = new GeneralTree<>(14);

        GeneralTree<Integer> a5 = new GeneralTree<>(5);
        GeneralTree<Integer> a4 = new GeneralTree<>(4);
        GeneralTree<Integer> a42 = new GeneralTree<>(4);
        GeneralTree<Integer> a9 = new GeneralTree<>(9);
        GeneralTree<Integer> a10 = new GeneralTree<>(10);
        GeneralTree<Integer> a3 = new GeneralTree<>(3);

        GeneralTree<Integer> a8 = new GeneralTree<>(8);
        GeneralTree<Integer> a13 = new GeneralTree<>(13);
        GeneralTree<Integer> a7 = new GeneralTree<>(7);

        // Armar subárboles
        a2.addChild(a1);
        a2.addChild(a12);
        a2.addChild(a14);

        a1.addChild(a5);
        a1.addChild(a4);

        a4.addChild(a9);
        a4.addChild(a10);
        a4.addChild(a5);

        a12.addChild(a8);
        a12.addChild(a42);
        a12.addChild(a7);

        a8.addChild(a3);
        a7.addChild(a13);


        // Resolver
        ParcialArboles10 parcial = new ParcialArboles10();
        parcial.tree= a2;
        List<Integer> resultado = parcial.resolver();
        System.out.println("Resultado obtenido: " + resultado);
    }
}
