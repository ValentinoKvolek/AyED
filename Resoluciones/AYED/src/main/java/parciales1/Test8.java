package main.java.parciales1;

import main.java.tp2.ejercicio1.BinaryTree;

public class Test8 {

    public static void main(String[] args) {
        // Construcción del árbol
        BinaryTree<Integer> root = new BinaryTree<>(2);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo11 = new BinaryTree<>(11);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);

        root.addLeftChild(nodo7);
        root.addRightChild(nodo5);

        nodo7.addLeftChild(nodo2);
        nodo7.addRightChild(nodo6);

        nodo6.addLeftChild(nodo5);
        nodo6.addRightChild(nodo11);

        nodo5.addRightChild(nodo9);

        nodo9.addLeftChild(nodo4); // el 5 de la derecha

        ParcialArboles8 prueba = new  ParcialArboles8 ();

        prueba.tree= root;

        // Pruebas
        System.out.println("Nivel 1 (esperado: null): " + prueba.minEnNivel(1));
        System.out.println("Nivel 2 (esperado: 2): " + prueba.minEnNivel(2));
        System.out.println("Nivel 3 (esperado: 4): " +prueba.minEnNivel(3));
    }
}

