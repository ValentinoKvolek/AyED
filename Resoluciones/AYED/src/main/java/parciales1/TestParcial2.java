package main.java.parciales1;

import main.java.tp2.ejercicio1.BinaryTree;

public class TestParcial2 {

    public static void main(String[] args) {

                // Crear nodos
                BinaryTree<Integer> a7 = new BinaryTree<>(7);
                BinaryTree<Integer> a56 = new BinaryTree<>(56);
                BinaryTree<Integer> a25 = new BinaryTree<>(25);
                BinaryTree<Integer> a38 = new BinaryTree<>(38);
                BinaryTree<Integer> a31 = new BinaryTree<>(31);
                BinaryTree<Integer> a5 = new BinaryTree<>(5);
                BinaryTree<Integer> a6 = new BinaryTree<>(6);
                BinaryTree<Integer> a87 = new BinaryTree<>(87);
                BinaryTree<Integer> a77 = new BinaryTree<>(77);
                BinaryTree<Integer> a16 = new BinaryTree<>(16);
                BinaryTree<Integer> a43 = new BinaryTree<>(43);
                BinaryTree<Integer> a94 = new BinaryTree<>(94);
                BinaryTree<Integer> a2 = new BinaryTree<>(2);
                BinaryTree<Integer> a9 = new BinaryTree<>(9);
                BinaryTree<Integer> a10 = new BinaryTree<>(10);
                BinaryTree<Integer> a3 = new BinaryTree<>(3);
                BinaryTree<Integer> a1 = new BinaryTree<>(1);

                // Conectar nodos según el diagrama
                a7.addLeftChild(a56);
                a7.addRightChild(a25);

                a56.addLeftChild(a38);
                a56.addRightChild(a31);

                a25.addLeftChild(a5);
                a25.addRightChild(a6);

                a38.addLeftChild(a87);
                a38.addRightChild(a77);

                a77.addLeftChild(a16);
                a16.addLeftChild(a43);
                a43.addLeftChild(a9);
                a43.addRightChild(a10);

                a31.addRightChild(a94);
                a94.addLeftChild(a3);
                a94.addRightChild(a2);
                a3.addLeftChild(a1);

                // Probar el método resolver
                ParcialArboles2v2 parcial = new ParcialArboles2v2();

                System.out.println("Camino con min = 2:");
                System.out.println(parcial.resolver(a7, 2));  // Debería devolver: 7-56-38-87

                System.out.println("Camino con min = 3:");
                System.out.println(parcial.resolver(a7, 3));  // Debería devolver: 7-56-38-77-16-43-9
            }
        }

