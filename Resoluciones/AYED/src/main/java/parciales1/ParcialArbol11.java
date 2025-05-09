package main.java.parciales1;

import main.java.tp3.ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParcialArbol11 {

    GeneralTree<Integer> tree;

    public List<Integer> caminoMasLargo() {

        List<Integer> res = new LinkedList<Integer>();
        List<Integer>caminoAct= new LinkedList<Integer>();

        caminoR(tree,res,caminoAct);

        return res;

    }


    private void caminoR(GeneralTree<Integer> nodo , List<Integer> res, List<Integer>caminoAct){

        if (!nodo.isEmpty()){
            caminoAct.add(nodo.getData());
        }


        if (!nodo.isLeaf()){

            List<GeneralTree<Integer>> hijos  = nodo.getChildren();

            for (GeneralTree<Integer> hijo : hijos){
                caminoR(hijo,res,caminoAct);
            }

        }else {

            if (caminoAct.size() > res.size()) {
                res.clear();
                res.addAll(caminoAct);
            }
        }

        caminoAct.removeLast();

    }
}
