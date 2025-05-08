package main.java.parciales1;

import main.java.tp3.ejercicio1.GeneralTree;

import java.util.Collections;
import java.util.List;

public class TestParcial7 {

    public static void main(String[] args) {


        // Crear nodos
        GeneralTree<Character> a = new GeneralTree<>('A');
        GeneralTree<Character> b = new GeneralTree<>('B');
        GeneralTree<Character> c = new GeneralTree<>('C');
        GeneralTree<Character> d = new GeneralTree<>('D');
        GeneralTree<Character> e = new GeneralTree<>('E');
        GeneralTree<Character> f = new GeneralTree<>('F');
        GeneralTree<Character> g = new GeneralTree<>('G');
        GeneralTree<Character> h = new GeneralTree<>('H');
        GeneralTree<Character> i = new GeneralTree<>('I');

        // Armar estructura
        a.addChild(b);
        a.addChild(c);
        a.addChild(d);

        b.addChild(e);

        c.addChild(f);
        c.addChild(g);

        f.addChild(h);
        f.addChild(i);

        // Probar método caminosPares

        ParcialArboles7 p = new ParcialArboles7();
        List<List<Character>> caminosPares = Collections.singletonList(p.caminosPares(a));
        System.out.println("Caminos con cantidad de nodos PAR:");
        for (List<Character> camino : caminosPares) {
            System.out.println(camino);
        }

    }
}
