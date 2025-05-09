package main.java.parciales1;

import main.java.tp2.ejercicio1.BinaryTree;

public class ParcialesArboles6 {

    BinaryTree<Integer> arbol = new BinaryTree<Integer>();

    public ParcialesArboles6(BinaryTree<Integer> raiz) {
        arbol = raiz;
    }


    public BinaryTree<Integer> nuevoTree() {

        BinaryTree<Integer> nuevoArbol = new BinaryTree<Integer>();

        nuevoArbol.setData(arbol.getData());

        nuevoTreeR(nuevoArbol, arbol, 0);

        return nuevoArbol;

    }

    private void nuevoTreeR(BinaryTree<Integer> arbolNuevo, BinaryTree<Integer> nodo,int nodoAnt) {

        nodoAnt = nodo.getData();

        if (nodo.hasLeftChild()){
            addLeft(arbolNuevo, nodo.getLeftChild(), nodoAnt);
            nuevoTreeR(arbolNuevo.getLeftChild(), nodo.getLeftChild(), nodoAnt);

        }

        if(nodo.hasRightChild()){
            addRight(arbolNuevo, nodo.getRightChild());
            nuevoTreeR(arbolNuevo.getRightChild(), nodo.getRightChild(), 0);
        }


    }

    private void addLeft(BinaryTree<Integer> arbolNuevo, BinaryTree<Integer> nodo, int nodoAnt ) {

        BinaryTree<Integer> nuevoNodo = new BinaryTree<Integer>();

        nuevoNodo.setData(nodo.getData() + nodoAnt);

        arbolNuevo.addLeftChild(nuevoNodo);

    }

    private void addRight(BinaryTree<Integer> arbolNuevo, BinaryTree<Integer> nodo) {

        BinaryTree<Integer> nuevoNodo = new BinaryTree<Integer>();

        nuevoNodo.setData(nodo.getData());

        arbolNuevo.addRightChild(nuevoNodo);

    }



}
