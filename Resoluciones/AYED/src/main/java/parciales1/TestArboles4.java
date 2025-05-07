package main.java.parciales1;

import main.java.tp3.ejercicio1.GeneralTree;
import java.util.List;

public class TestArboles4 {

    public static void main(String[] args) {
        // Crear árbol
        GeneralTree<Integer> root = new GeneralTree<>(10);

        GeneralTree<Integer> n2 = new GeneralTree<>(8);
        GeneralTree<Integer> n3 = new GeneralTree<>(42);
        GeneralTree<Integer> n4 = new GeneralTree<>(-5);

        root.addChild(n2);
        root.addChild(n3);
        root.addChild(n4);

        GeneralTree<Integer> n5 = new GeneralTree<>(5);
        GeneralTree<Integer> n6 = new GeneralTree<>(22);


        n2.addChild(n5);
        n2.addChild(n6);

        n5.addChild(new GeneralTree<>(-6));

        n6.addChild(new GeneralTree<>(28));
        n6.addChild(new GeneralTree<>(55));
        n6.addChild(new GeneralTree<>(18));

        GeneralTree<Integer> n7 = new GeneralTree<>(19);

        n4.addChild(n7);
        n4.addChild(new GeneralTree<>(-9));
        n7.addChild(new GeneralTree<>(4));


        // Probar método
        ParcialArboles4 parcial = new ParcialArboles4();
        parcial.tree = root;

        List<Integer> resultado2 = parcial.camino(2);
        System.out.println(resultado2);

        List<Integer> resultado3 = parcial.camino(3);
        System.out.println("Resultado con num = 3 (esperado: lista vacía):");
        System.out.println(resultado3);
    }
}


