package main.java.parciales1;

import main.java.tp2.ejercicio1.BinaryTree;

import java.util.LinkedList;

public class ParcialArboles2 {

    BinaryTree<Integer> bt = new BinaryTree<Integer>();


    public LinkedList<Integer> resolver(BinaryTree<Integer> bt, int min) {

        LinkedList<Integer> resueltado = new LinkedList<Integer>();

        LinkedList<Integer> caminoActual = new LinkedList<Integer>();


        resolverR(bt,min,resueltado, caminoActual);


        return resueltado;
    }


    private boolean resolverR(BinaryTree<Integer> nodo, int min, LinkedList<Integer> resueltado, LinkedList<Integer> caminoActual) {

        if (!(nodo.getData() ==  null)){
            caminoActual.add(nodo.getData()); //ya sea un nodo o una hoja. no me importa mientras no sea (mas chequeo para buena practica que otra cosa..) lo agrego.
        }

        if(!nodo.isLeaf()){
            if(nodo.hasLeftChild()){
                if(resolverR(nodo.getLeftChild(),min,resueltado,caminoActual))
                    return true;
            }
            if(nodo.hasRightChild()){
                if(resolverR(nodo.getRightChild(),min,resueltado,caminoActual))
                    return true;
            }
        }

        if(nodo.isLeaf()){

            int cantP = 0;

            for (Integer numero : caminoActual) {
                if (numero % 2 == 0) {
                    cantP++;
                }
            }

            if (cantP >= min) {

                resueltado.addAll(caminoActual);
                return true;
            }
        }

        caminoActual.removeLast(); //backtracking.
        return false;
    }
}
