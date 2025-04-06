package main.java.tp2.ejercicio7;

import main.java.tp1.ejercicio8.Queue;
import main.java.tp2.ejercicio1.BinaryTree;

public class ParcialArboles {

    // arbol binario de enteros no repetidos.

    BinaryTree<Integer> arbol = new BinaryTree<Integer>();

    public ParcialArboles(BinaryTree<Integer> arbol){

        this.arbol= arbol;

    }

    public boolean isLeftTree(int num){

        int numIzqHijosUnicos =0;
        int numDerHijosUnicos =0;

        BinaryTree<Integer> nodo = null;

        Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();

        cola.enqueue(arbol);
        cola.enqueue(null);

        while(!arbol.isEmpty()){

            nodo =  cola.dequeue();
            if(nodo != null) {
                if (nodo.getData() == num) {
                    if (nodo.isLeaf()) {
                        return false;
                    }

                    if (nodo.hasLeftChild()) {
                        numIzqHijosUnicos = calcularHijos(nodo.getLeftChild());
                    } else {
                        numIzqHijosUnicos = -1;
                    }

                    if (nodo.hasRightChild()) {
                        numDerHijosUnicos = calcularHijos(nodo.getRightChild());
                    } else {
                        numDerHijosUnicos = -1;
                    }
                    System.out.println("izq : " +  numIzqHijosUnicos+ " der: "+ numDerHijosUnicos);
                    return numIzqHijosUnicos > numDerHijosUnicos;
                }
            }

            if (nodo != null){

                if(nodo.hasLeftChild()){
                    cola.enqueue(nodo.getLeftChild());
                }

                if(nodo.hasRightChild()){
                    cola.enqueue(nodo.getRightChild());
                }

            }else if(!cola.isEmpty()){
                cola.enqueue(null);
            }
        }

        return false;
    }

    private int calcularHijos(BinaryTree<Integer> nodo){

        if(nodo == null || nodo.isLeaf()) {return 0;}

            int num = 0;

            if (!nodo.hasRightChild() || !nodo.hasLeftChild()) { //si tiene hijo unico cuento 1
                num = 1;
            }

            if (nodo.hasLeftChild()) {
                num += calcularHijos(nodo.getLeftChild());
            }
            if (nodo.hasRightChild()) {
                num += calcularHijos(nodo.getRightChild());
            }
            return num;
    }
}
