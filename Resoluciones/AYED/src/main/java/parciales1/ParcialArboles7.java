package main.java.parciales1;



import main.java.tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles7 {

    GeneralTree<Character> tree;

    public List<Character> caminosPares(GeneralTree<Character> tree) {

        List<Character> resultado =new LinkedList<Character>();

        List<Character> caminoAct = new LinkedList<Character>();

        int cantNodos = 0;

        caminosParesR(tree, resultado, caminoAct, cantNodos );

        return resultado;
    };


    private void caminosParesR(GeneralTree<Character> nodo, List<Character> resultado, List<Character> caminoAct, int cantNodos) {

        if(!nodo.isEmpty()){

            caminoAct.add(nodo.getData());

            cantNodos++;


        }

        if(!nodo.isLeaf()){

            List<GeneralTree<Character>> children = nodo.getChildren();
            for (GeneralTree<Character> child : children) {
                caminosParesR( child, resultado, caminoAct, cantNodos );
            }
        }

        if(nodo.isLeaf()){

            if(cantNodos %2 == 0 ){

                resultado.addAll(caminoAct);
                resultado.add(' ');

            }
        }

        caminoAct.removeLast();

    }
}
