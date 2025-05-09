package main.java.parciales1;


import main.java.tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles4 {


    GeneralTree<Integer> tree;


    public List<Integer> camino(int num) {

        List<Integer> resultado = new LinkedList<Integer>();
        caminoR(tree, num, resultado, new LinkedList<Integer>());

        return resultado;

    }



    private boolean caminoR(GeneralTree<Integer> nodo, int num, List<Integer> resultado, List<Integer> camino) {


        if (!nodo.isLeaf()) {

            List<GeneralTree<Integer>> hijos = nodo.getChildren();

            if (hijos.size() < num) {
                return false;
            }

            camino.add(nodo.getData());

            for (GeneralTree<Integer> hijo : hijos){

                if (caminoR(hijo, num, resultado, camino)) {
                    return true;
                }

            }
        }

        if(nodo.isLeaf()){
            camino.add(nodo.getData());
            resultado.addAll(camino);
            return true;
        }

        camino.removeLast();
        return false;

    }

}
