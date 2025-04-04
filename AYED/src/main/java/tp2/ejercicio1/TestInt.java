package main.java.tp2.ejercicio1;

public class TestInt{

    public static void main(String[] args) {
        BinaryTree<Integer> A = new BinaryTree<>(40);
        BinaryTree<Integer> B = new BinaryTree<>(25);
        BinaryTree<Integer> C = new BinaryTree<>(78);

        A.addLeftChild(B);
        A.addRightChild(C);

        BinaryTree<Integer> D = new BinaryTree<>(10);
        BinaryTree<Integer> E = new BinaryTree<>(32);

        B.addLeftChild(D);
        B.addRightChild(E);

        ContadorArbol cont = new ContadorArbol(A);

        System.out.println(cont.numerosPares());
        System.out.println("========================");
        System.out.println(cont.numerosPares2());

    }
}
