package main.java.tp2.ejercicio7;

import main.java.tp1.ejercicio8.Queue;
import main.java.tp2.ejercicio1.BinaryTree;

import java.util.Objects;

public class ParcialArboles {

    // arbol binario de enteros no repetidos.

    BinaryTree<Integer> arbol = new BinaryTree<Integer>();

    public ParcialArboles(BinaryTree<Integer> arbol){

        this.arbol= arbol;

    }
    public ParcialArboles(){};

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

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        BinaryTree<Integer> nodo1 = new BinaryTree<Integer>();
        BinaryTree<Integer> nodo2 = new BinaryTree<Integer>();
        Queue<BinaryTree<Integer>> cola1 = new Queue<BinaryTree<Integer>>();
        Queue<BinaryTree<Integer>> cola2 = new Queue<BinaryTree<Integer>>();
        cola1.enqueue(arbol1);
        cola1.enqueue(null);
        cola2.enqueue(arbol2);
        cola2.enqueue(null);

        while(!cola1.isEmpty()){
            nodo1=cola1.dequeue();
            nodo2=cola2.dequeue();
            if(nodo1 !=null ){
                if(nodo2 != null){
                    if(!Objects.equals(nodo1.getData(), nodo2.getData())){
                        return false;
                    }
                }
            }

            if (nodo1 != null && nodo2 != null){

                if(nodo1.hasLeftChild()){
                    cola1.enqueue(nodo1.getLeftChild());
                    cola2.enqueue(nodo2.getLeftChild());
                }

                if(nodo1.hasRightChild()){
                    cola1.enqueue(nodo1.getRightChild());
                    cola2.enqueue(nodo2.getRightChild());
                }

            }else if(!cola1.isEmpty()){
                cola1.enqueue(null);
                cola2.enqueue(null);
            }
        }
        return true;
    }


}
