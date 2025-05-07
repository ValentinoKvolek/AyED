package main.java.parciales1;


//3) Llamaremos a un árbol general creciente si en cada nivel del árbol la cantidad de nodos que hay en ese
//nivel es igual al valor del nivel más 1. Es decir, el nivel 0 tiene exactamente un nodo, el nivel 1 tiene
//exactamente 2 nodos, el nivel k tiene exactamente k+1 nodos. Comprobar si un árbol general es
//creciente y en caso de que lo sea, retornar el nodo del árbol con mayor cantidad de hijos, en caso de
//no serlo, retornar null

import main.java.tp1.ejercicio8.Queue;
import main.java.tp3.ejercicio1.GeneralTree;

public class ParcialArboles5 {

    GeneralTree<Integer> tree;

    public Integer esCreciente() {

        int nivel= 0;
        int cantNodoNiveActual =0;
        int maxHijos = Integer.MIN_VALUE;
        Integer nodomax= null;

        Queue<GeneralTree<Integer>> queue = new Queue<>();

        queue.enqueue(tree);
        queue.enqueue(null); //marca de nivel

        while (!queue.isEmpty()) {

            GeneralTree<Integer> nodo = queue.dequeue();

            if (nodo != null) { //si sigo en el mismo nivel

                cantNodoNiveActual++; //cuantos nodos hay en este nivel.  no en lo hijos. ojo error muy comun.

                int hijos = nodo.getChildren().size();

                if(hijos > maxHijos) {
                    maxHijos = hijos;
                    nodomax = nodo.getData();
                }

                for(GeneralTree<Integer> hijo : nodo.getChildren()) {
                    queue.enqueue(hijo);
                }

            }else {

                if (cantNodoNiveActual != nivel + 1) {
                    return null;
                }

                if (!queue.isEmpty()) { //si la cola no esta vacia quiere decir que un nivel.

                    queue.enqueue(null); //pongo la siguiente marca de nivel

                }
                nivel++;

                cantNodoNiveActual = 0;

            }

        }

        return nodomax;
    }

}
