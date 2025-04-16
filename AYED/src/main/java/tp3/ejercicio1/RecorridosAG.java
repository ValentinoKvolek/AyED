package main.java.tp3.ejercicio1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecorridosAG {

    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a,Integer n) {

        List<Integer> aux = new LinkedList<Integer>();
        /*
         Metodo que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
         pasados como parámetros, recorrido en preorden
         */
        if(!a.isEmpty() && a != null){

            if(a.getData() %2 != 0 && a.getData() > n){
                aux.add(a.getData());
            }

            List<GeneralTree<Integer>> children = a.getChildren();
            Iterator<GeneralTree<Integer>> it = children.iterator();

            //preOrden.
            for (GeneralTree<Integer> child : a.getChildren()) {
                aux.addAll(numerosImparesMayoresQuePreOrden(child, n));
            }

        }

        return  aux;
    }
}
