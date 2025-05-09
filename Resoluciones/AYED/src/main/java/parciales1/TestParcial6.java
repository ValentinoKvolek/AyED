package main.java.parciales1;

import main.java.tp2.ejercicio1.BinaryTree;

public class TestParcial6 {

    public static void main(String[] args) {



        BinaryTree<Integer> raiz = new BinaryTree<>(1);
        BinaryTree<Integer> n1 = new BinaryTree<>(2);
        BinaryTree<Integer> n2 = new BinaryTree<>(3);
        BinaryTree<Integer> h1 = new BinaryTree<>(4);
        BinaryTree<Integer> h2 = new BinaryTree<>(5);
        BinaryTree<Integer> h3 = new BinaryTree<>(6);
        BinaryTree<Integer> h4 = new BinaryTree<>(7);

        raiz.addLeftChild(n1);
        raiz.addRightChild(n2);

        n1.addLeftChild(h1);
        n2.addLeftChild(h2);

        n2.addRightChild(h3);
        h2.addLeftChild(h4);

        ParcialesArboles6 p= new ParcialesArboles6(raiz);
        BinaryTree<Integer> test = p.nuevoTree();

        System.out.println(raiz.toString());


        System.out.println(" ");

        System.out.println(test.toString());

    }

}
