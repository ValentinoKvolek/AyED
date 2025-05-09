package main.java.parciales1;

import main.java.tp3.ejercicio1.GeneralTree;

import java.util.List;

public class Parcial13 {

    public int mayor (GeneralTree<Integer> tree){

        int mayor = -9999;

        mayor= resolver(tree, mayor);

        return mayor;

    }

    public int resolver(GeneralTree<Integer> nodo, int mayor) {

        if (!nodo.isLeaf()) {

            List<GeneralTree<Integer>> children = nodo.getChildren();

            for (GeneralTree<Integer> child : children) {
                mayor = resolver(child, mayor);
            }

            if (nodo.getData() > mayor) {
                mayor = nodo.getData();
            }
        }

        if(nodo.getData() >  mayor){
            mayor = nodo.getData();
        }

        return mayor;
    }
}