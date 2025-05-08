package main.java.parciales1;

import main.java.tp1.ejercicio8.Queue;
import main.java.tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles3 {


    GeneralTree<Integer> tree;


    public LinkedList<Integer> resolver(GeneralTree<Integer> tree) {


        LinkedList<Integer> resultado = new LinkedList<>();

        resultado.add(tree.getData());//la raiz va si o si

        resolverR(tree, resultado);

        return resultado;


    }

    public boolean resolverR(GeneralTree<Integer> nodo, LinkedList<Integer> resultado) {

        List<GeneralTree<Integer>> hijos = nodo.getChildren();

        int pos = nodo.getData();
        int posActual = 0;

        for (GeneralTree<Integer> hijo : hijos) {

            posActual ++;

            if(posActual == pos) {
                resultado.add(hijo.getData());
                if (resolverR(hijo, resultado)){
                    return true;
                };
            }
        }

        //cuando llegue a una hoja
        return true;
    }



}