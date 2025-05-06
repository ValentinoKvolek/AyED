package main.java.parciales1;

import main.java.tp1.ejercicio8.Queue;
import main.java.tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;

public class ParcialArboles3 {


    GeneralTree<Integer> tree;


    public LinkedList<GeneralTree<Integer>> resolver(GeneralTree<Integer> tree) {

        LinkedList<GeneralTree<Integer>>res = new LinkedList<GeneralTree<Integer>>();

        Queue<GeneralTree<Integer>> queue = new Queue<>();

        int posSig = tree.getData();

        int auxp=0;

        res.add(tree); //guardo la raiz

        queue.enqueue(tree);

        while(!queue.isEmpty()) {

            int cantHijosActual = queue.size(); //cantidad de hijos que tiene el nodo

           for (int i = 0; i < cantHijosActual; i++) {

               GeneralTree<Integer> aux = queue.dequeue();

               if (i == posSig) {

                   res.add(aux); //agrego camino valido.

                   auxp = aux.getData(); //actualizo la prox pos.

                   for(GeneralTree<Integer> hijo : aux.getChildren()) {
                       queue.enqueue(hijo);
                   }

               }
           }

           posSig = auxp;

        }

        return res;
    }


}
