package main.java.parciales1;

import main.java.tp2.ejercicio1.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles2v2 {



    public List<Integer> resolver(BinaryTree<Integer> tree , int min){


        int cantPares = 0;

        List<Integer> caminoActual = new LinkedList<>();

        resolverR(tree,min,caminoActual, cantPares);

        return caminoActual;
    }

    // en este caso la hago bool por que quiero que devuelva el primer camuino.

    private boolean resolverR(BinaryTree<Integer> nodo,  int min, List<Integer> caminoActual, int cantPares){


        if(!nodo.isEmpty()) {

            caminoActual.add(nodo.getData());

            if(nodo.getData() % 2 ==0){
                cantPares++;
            }

        }

        if(!nodo.isLeaf()) {

            if (nodo.hasLeftChild()) {
                if (resolverR(nodo.getLeftChild(), min, caminoActual,  cantPares)) {
                    return true;
                }
            }
            if (nodo.hasRightChild()) {
                if (resolverR(nodo.getRightChild(), min, caminoActual,  cantPares)) {
                    return true;
                }
            }
        }else{ //si el nodo es hoja

            if(cantPares >= min){
                return true;
            }

        }

        caminoActual.removeLast();
        return false;

    }

}
