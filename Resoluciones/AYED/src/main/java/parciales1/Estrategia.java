package main.java.parciales1;

import main.java.tp3.ejercicio1.GeneralTree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Estrategia {


    GeneralTree<Compuesto> tree;

    public List <GeneralTree<Compuesto>> mejorEstrategia (GeneralTree<Compuesto> arbol) {

        double tiempoRamaAct =0;

        double tiempoMinimo = 9999.0;

        List<GeneralTree<Compuesto>>caminoMin = new LinkedList<GeneralTree<Compuesto>>();

        List<GeneralTree<Compuesto>> caminoActual = new LinkedList<GeneralTree<Compuesto>>();

        mejorEstrategiaR(arbol,tiempoRamaAct,tiempoMinimo, caminoMin,caminoActual );

        return caminoMin;
    }

    private double mejorEstrategiaR(GeneralTree<Compuesto> nodo, double tiempoRamaAct, double min, List<GeneralTree<Compuesto>> caminoMin, List<GeneralTree<Compuesto>> caminoActual){


        if(!(nodo.getData() == null)){ //segun el enunciado me dice que la raiz esta vacia.

            caminoActual.add(nodo);

            //entonces si no es raiz calculo el tiempo.

            tiempoRamaAct += nodo.getData().getTipo() * nodo.getData().getVueltas() + 10 ;

        }

        if(nodo.isLeaf()){

            if(tiempoRamaAct < min){

                min = tiempoRamaAct;

                caminoMin.clear();

                caminoMin.addAll(caminoActual);
            }

        }

        // como no es una hoja, calculo los hijos.

        for(GeneralTree<Compuesto> hijo : nodo.getChildren()){
           min =  mejorEstrategiaR(hijo, tiempoRamaAct, min, caminoMin, caminoActual);

        }

        //cuando me voy hago BackTracking

        if(!(nodo.getData() == null)){
            caminoActual.removeLast();
        }


        return min;

    }
}
