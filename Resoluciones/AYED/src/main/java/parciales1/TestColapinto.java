package main.java.parciales1;

import main.java.tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class TestColapinto {

    public static void main(String[] args) {

        GeneralTree<Compuesto> raiz = new GeneralTree<>(null);
        GeneralTree<Compuesto> hoja1 = new GeneralTree<>(new Compuesto(10, "Soft"));
        GeneralTree<Compuesto> hoja2 = new GeneralTree<>(new Compuesto(10, "Soft"));
        GeneralTree<Compuesto> hoja3 = new GeneralTree<>(new Compuesto(30, "Hard"));
        GeneralTree<Compuesto> hoja4 = new GeneralTree<>(new Compuesto(20, "Hard"));
        GeneralTree<Compuesto> hoja5 = new GeneralTree<>(new Compuesto(30, "Hard"));
        GeneralTree<Compuesto> hoja6 = new GeneralTree<>(new Compuesto(15, "Med"));
        GeneralTree<Compuesto> hoja7 = new GeneralTree<>(new Compuesto(15, "Med"));
        GeneralTree<Compuesto> hoja8 = new GeneralTree<>(new Compuesto(35, "Hard"));
        GeneralTree<Compuesto> hoja9 = new GeneralTree<>(new Compuesto(15, "Soft"));

        raiz.addChild(hoja1);
        raiz.addChild(hoja4);
        raiz.addChild(hoja8);

        hoja1.addChild(hoja2);
        hoja2.addChild(hoja3);

        hoja4.addChild(hoja5);
        hoja4.addChild(hoja6);
        hoja6.addChild(hoja7);

        hoja8.addChild(hoja9);

        Estrategia p = new Estrategia();

        List<GeneralTree<Compuesto>> lista = new LinkedList<>();

        lista = p.mejorEstrategia(raiz);

        System.out.println("Camino menor:");
        if (!lista.isEmpty()) {

            for (GeneralTree<Compuesto> c : lista) {
                System.out.println(c.getData());
            }
        }
    }
}

