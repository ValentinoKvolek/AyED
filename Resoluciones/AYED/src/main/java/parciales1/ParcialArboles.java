package main.java.parciales1;

import main.java.tp1.ejercicio8.Queue;

import main.java.tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {

    GeneralTree<Integer> tree;


    public List<Integer> nivel(int num) {

        List<Integer> resultado = new LinkedList<>();

        boolean cumple = false;

        Queue<GeneralTree<Integer>> queue = new Queue<>();

        queue.enqueue(tree);
        queue.enqueue(null); //marca de nivel.

        while (!queue.isEmpty()) {

            GeneralTree<Integer> nodo = queue.dequeue();

            if (nodo != null) {

                int cantH = 0;

                for(GeneralTree<Integer> hijo : nodo.getChildren()) {
                    cantH++;
                    queue.enqueue(hijo);
                }

                if(cantH == num) {
                    resultado.add(nodo.getData());
                    cumple = true;
                }else cumple = false;  //esto lo hago para que si un solo hijo de todos los del nivel no cumple no retorne.

            }else{

                if (cumple){
                    return resultado;
                }

                resultado.clear();

                queue.enqueue(null);
            }
        }

        return resultado;
    }

}
