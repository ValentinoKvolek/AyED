package main.java.parciales1;

import main.java.tp3.ejercicio1.GeneralTree;
import java.util.LinkedList;
import java.util.List;

public class ParcialArboles10 {

    GeneralTree<Integer> tree;


    public List<Integer> resolver(){


        List<Integer> sumaResultados = new LinkedList<>();


        resolverR(tree,  sumaResultados);

        return sumaResultados;
    }

    private Integer resolverR(GeneralTree<Integer> nodo, List<Integer> sumaResultados) {

        int suma=0;
        int cantH=0;

        List<GeneralTree<Integer>> hijos = nodo.getChildren();

        for (GeneralTree<Integer> hijo : hijos) {
            cantH++;
            suma += resolverR(hijo, sumaResultados);
        }

        if(!(cantH %2==0)){
            sumaResultados.add(suma);
        }

        suma=0;

        suma += nodo.getData();



        return suma;
    }
}
