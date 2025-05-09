package main.java.parciales1;

import main.java.tp2.ejercicio1.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Parcial12 {


    public List<Integer> resolver(BinaryTree<Integer> tree){

        List<Integer> res = new LinkedList<Integer>();

        resolverR(tree, res);

        return res;
    }


    private int resolverR(BinaryTree<Integer> nodo, List<Integer> res){


        int sumahI=0;
        int sumahD=0;

        int total= 0;

        if(!nodo.isLeaf()){

            if(nodo.hasLeftChild()){
                sumahI+= resolverR(nodo.getLeftChild(), res);
            }

            if(nodo.hasRightChild()){
                sumahD+= resolverR(nodo.getRightChild(), res);
            }

        }

        if(sumahI == sumahD){
            res.add(nodo.getData());
        }

        total = sumahI+sumahD + 1;

        return total;
    }
}
