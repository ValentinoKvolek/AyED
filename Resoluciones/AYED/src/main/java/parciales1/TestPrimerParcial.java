package main.java.parciales1;

import main.java.tp3.ejercicio1.GeneralTree;
import main.java.tp3.ejercicio1.GeneralTree;

public class TestPrimerParcial {


        public static void main(String[] args) {
            GeneralTree<Integer> tree = new GeneralTree<>(10);

            // Primer nivel
            GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
            GeneralTree<Integer> nodoMenos5 = new GeneralTree<>(-5);
            tree.addChild(nodo8);
            tree.addChild(nodoMenos5);

            // Segundo nivel (hijos de 8)
            GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
            GeneralTree<Integer> nodo22 = new GeneralTree<>(22);
            GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
            nodo8.addChild(nodo5);
            nodo8.addChild(nodo22);
            nodo8.addChild(nodo7);

            // Segundo nivel (hijo de -5)
            GeneralTree<Integer> nodo19 = new GeneralTree<>(19);
            nodoMenos5.addChild(nodo19);

            // Tercer nivel (hijos de 5)
            nodo5.addChild(new GeneralTree<>(-6));
            nodo5.addChild(new GeneralTree<>(2));
            nodo5.addChild(new GeneralTree<>(6));

            // Tercer nivel (hijos de 22)
            nodo22.addChild(new GeneralTree<>(28));
            nodo22.addChild(new GeneralTree<>(55));
            nodo22.addChild(new GeneralTree<>(18));

            // Tercer nivel (hijos de 19)
            nodo19.addChild(new GeneralTree<>(4));
            nodo19.addChild(new GeneralTree<>(2));
            nodo19.addChild(new GeneralTree<>(8));

            ParcialArboles parcial = new ParcialArboles();
            parcial.tree= tree;
            System.out.println("Resultado:");
            System.out.println(parcial.nivel(3)); // Probá con el número de hijos mínimo por nivel que querés evaluar


        }
    }

