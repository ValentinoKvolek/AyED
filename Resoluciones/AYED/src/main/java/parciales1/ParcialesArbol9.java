package main.java.parciales1;

import main.java.tp2.ejercicio1.BinaryTree;

public class ParcialesArbol9 {


    public Integer sumaImparesPosOrdenMayorA (BinaryTree<Integer> ab, int limite){

        Integer suma = 0;

        return recorridoR(ab, suma, limite);

    }


    private Integer recorridoR(BinaryTree<Integer> nodo, int suma, int limite){


        if(nodo.hasLeftChild()){
           suma = recorridoR(nodo.getLeftChild(), suma, limite);
        }

        if(nodo.hasRightChild()){
           suma = recorridoR(nodo.getRightChild(), suma, limite);
        }

        if(!(nodo.getData() % 2 == 0)){

            if (nodo.getData() > limite){

                System.out.println(nodo.getData());
                suma +=  nodo.getData();
            }
        }

        return suma;
    }

}
