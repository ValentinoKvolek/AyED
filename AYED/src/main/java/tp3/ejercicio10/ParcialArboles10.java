package main.java.tp3.ejercicio10;

import main.java.tp3.ejercicio1.GeneralTree;

import javax.xml.transform.Result;
import java.util.LinkedList;
import java.util.List;

public class ParcialArboles10 {


    public List<Integer> resolver(GeneralTree<Integer> arbol){

        List <Integer> resultado = new LinkedList<Integer>();

        int cantNivel = 0;

        int maximo =0;

        int caminoMax= Integer.MIN_VALUE;

        resolverRec(arbol, resultado, cantNivel, maximo, caminoMax);

        return  resultado;

    }

    private List<Integer> resolverRec(GeneralTree<Integer> nodo, List<Integer> resultado, int cantNivel, int maximo, int caminoMax){

            List <Integer> aux = new LinkedList<Integer>();

            if(nodo.isEmpty()){
                return resultado;
            }

            if(!nodo.isLeaf()){

                if(nodo.getData() == 1){
                    aux.add(nodo.getData()); //add el 1.
                }

                maximo = maximo + ( nodo.getData() * cantNivel);

                List<GeneralTree<Integer>> hijos  = nodo.getChildren();

                cantNivel++;

                for(GeneralTree<Integer> hijo : hijos ){

                    resolverRec(hijo, resultado,cantNivel,maximo, caminoMax);

                }

                return resultado;

            }

            if(nodo.getData() == 1){

                aux.add(nodo.getData()); //add el 1.

            }

            maximo = maximo + ( nodo.getData() * cantNivel);

            if (maximo > caminoMax){

                resultado.addAll(aux);

            }

            return resultado;
    }
}