package main.java.tp2.ejercicio7;

import main.java.tp2.ejercicio1.BinaryTree;

public class InfoNodo {
    BinaryTree<Integer> nodo;
    int sumaTotal;
    int valorNodoPadre;

    InfoNodo(BinaryTree<Integer> nodo, int total, int padre) {
        this.nodo = nodo;
        this.sumaTotal = total;
        this.valorNodoPadre = padre;
    }
}
