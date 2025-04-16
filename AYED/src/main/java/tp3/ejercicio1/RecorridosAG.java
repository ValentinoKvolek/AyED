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

        if(!a.isEmpty()){

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

    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){


        /*

         Metodo que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
         pasados como parámetros, recorrido en inorden

        */

        List<Integer> aux = new LinkedList<Integer>();

        if(!a.isEmpty()){

            List<GeneralTree<Integer>> children = a.getChildren();


            //procesa el primer hijo subarbol.
            if (!children.isEmpty()) {

                //si ese sub arbol tiene un hijo lo procesa.
                aux.addAll(numerosImparesMayoresQueInOrden(children.get(0), n));
            }

            if(a.getData() %2 != 0 && a.getData() > n){
                aux.add(a.getData());
            }

            //procesa los 'hermanos del primer hijo sub arbol.'
            for (int i = 1; i < children.size(); i++) {
                aux.addAll(numerosImparesMayoresQueInOrden(children.get(i), n));
            }

        }
        return aux;

    }
}
