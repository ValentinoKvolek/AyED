package main.java.parciales1;

import main.java.tp2.ejercicio1.BinaryTree;

import java.util.List;

public class Test12 {

    public static void main(String[] args) {


        BinaryTree<Integer> root = new BinaryTree<>(2);
        BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo16 = new BinaryTree<>(16);
        BinaryTree<Integer> nodo22 = new BinaryTree<>(22);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(8);

        root.addLeftChild(nodo1);
        root.addRightChild(nodo5);
        nodo1.addLeftChild(nodo16);
        nodo1.addRightChild(nodo6);
        nodo5.addRightChild(nodo8);
        nodo8.addLeftChild(nodo22);

        Parcial12 res = new Parcial12();
        List<Integer> lista =  res.resolver(root);

        System.out.println(lista);
    }
}
