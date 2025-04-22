package main.java.tp3.ejercicio9;

import main.java.tp3.ejercicio1.GeneralTree;

import java.util.List;

public class ParcialArboles {

    static boolean cumple;


    public static boolean  esDeSeleccion(GeneralTree<Integer> arbol){

        //devuelve true si el árbol recibido por parámetro es de selección, falso sino lo es.

        cumple = true;

        esDeSeleccionRec(arbol);


        return cumple;

    }

    private static void esDeSeleccionRec(GeneralTree<Integer> nodo){

            if(nodo.isEmpty()){
                return;
            }

            if(!nodo.isLeaf()){

                int hijoMin= 99;

                List<GeneralTree<Integer>> hijos = nodo.getChildren();

                for (GeneralTree<Integer> hijo : hijos){

                    if(hijo.getData() < hijoMin){

                        hijoMin = hijo.getData();

                    }

                    esDeSeleccionRec(hijo);
                }

                if(nodo.getData() != hijoMin){
                    cumple= false;
                    return;
                }
            }
            return;
    }
}
