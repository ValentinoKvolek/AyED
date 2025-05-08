package main.java.parciales1;

import main.java.tp1.ejercicio8.Queue;

import main.java.tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {

    public GeneralTree<Integer> arbol;


    public LinkedList<Integer> nivel(int num){

        LinkedList<Integer>resultado = new LinkedList<>(); // aca guardo el result.

        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();

        cola.enqueue(arbol); //raiz

        LinkedList<GeneralTree<Integer>> nivelActual = new LinkedList<>();

        cola.enqueue(null); // marca para saber que ese nivel termino.

        while (!cola.isEmpty()){

            GeneralTree<Integer> aux = cola.dequeue();

            if (aux != null && aux.getData() != null){

                nivelActual.add(aux);

                List<GeneralTree<Integer>> hijos = aux.getChildren();

                for (GeneralTree<Integer> hijo : hijos){

                    if (hijo != null){
                        cola.enqueue(hijo);
                    }
                }
            }
            else {
                if (!cola.isEmpty()) {

                    boolean cumple = true;

                    for (GeneralTree<Integer> nodo : nivelActual){

                        if(nodo.getChildren().size() < num) { //comparo la cantidad de hijos que tienen todos los nodos de ese nivel.
                            cumple = false;
                            break;
                        }

                    }

                    if(cumple){

                        for (GeneralTree<Integer> nodo : nivelActual) {
                            resultado.add(nodo.getData());
                        }

                        return resultado;
                    }


                    nivelActual.clear();

                    cola.enqueue(null); //marca de nivel

                }
            }
        }

        return resultado;

    }

}
