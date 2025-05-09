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

        if (!nodo.isLeaf()){

            List<GeneralTree<Integer>> children = nodo.getChildren();

            if (children.size() >= num){
                camino.add(nodo.getData());
            }else{
                return false;
            }

            for (GeneralTree<Integer> child : children){
                if(caminoR(child, num, resultado, camino)){
                    return true;
                }

            }
        }else{

            camino.add(nodo.getData());

            resultado.addAll(camino);
            return true;
        }

        return false;
    }



}
