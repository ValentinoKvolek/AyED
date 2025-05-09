package main.java.parciales1;

import main.java.tp2.ejercicio1.BinaryTree;

public class Test9 {

        public static void main(String[] args) {

            BinaryTree<Integer> root = new BinaryTree<>(7);
            BinaryTree<Integer> n56 = new BinaryTree<>(56);
            BinaryTree<Integer> n25 = new BinaryTree<>(25);
            BinaryTree<Integer> n38 = new BinaryTree<>(38);
            BinaryTree<Integer> n31 = new BinaryTree<>(31);
            BinaryTree<Integer> n5 = new BinaryTree<>(5);
            BinaryTree<Integer> n6 = new BinaryTree<>(6);
            BinaryTree<Integer> n87 = new BinaryTree<>(87);
            BinaryTree<Integer> n77 = new BinaryTree<>(77);
            BinaryTree<Integer> n94 = new BinaryTree<>(94);
            BinaryTree<Integer> n16 = new BinaryTree<>(16);
            BinaryTree<Integer> n2 = new BinaryTree<>(2);
            BinaryTree<Integer> n43 = new BinaryTree<>(43);
            BinaryTree<Integer> n1 = new BinaryTree<>(1);
            BinaryTree<Integer> n9 = new BinaryTree<>(9);
            BinaryTree<Integer> n10 = new BinaryTree<>(10);

            root.addLeftChild(n56);
            root.addRightChild(n25);

            n56.addLeftChild(n38);
            n56.addRightChild(n31);

            n25.addLeftChild(n5);
            n25.addRightChild(n6);

            n38.addLeftChild(n87);
            n38.addRightChild(n77);

            n31.addRightChild(n94);
            n77.addLeftChild(n16);

            n16.addRightChild(n43);
            n43.addLeftChild(n9);
            n43.addRightChild(n10);

            n94.addRightChild(n2);
            n2.addLeftChild(n1);



            ParcialesArbol9 parcial = new ParcialesArbol9();

            int resultado = parcial.sumaImparesPosOrdenMayorA(root, 30);
            System.out.println("Resultado esperado: 238");
            System.out.println("Resultado obtenido: " + resultado);
        }
    }
