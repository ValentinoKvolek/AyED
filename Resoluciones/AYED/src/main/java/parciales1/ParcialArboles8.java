package main.java.parciales1;

import main.java.tp1.ejercicio8.Queue;
import main.java.tp2.ejercicio1.BinaryTree;

public class ParcialArboles8 {

    BinaryTree<Integer> tree;

    public Integer minEnNivel(int n){

        Integer min = Integer.MAX_VALUE;

        Queue<BinaryTree<Integer>> queue = new Queue<>();

        queue.enqueue(tree);
        queue.enqueue(null); // marca de nivel.
        int nivel = 0;

        while(!queue.isEmpty()){

            BinaryTree<Integer> current = queue.dequeue();

            if(current != null) {

                if (current.hasLeftChild()) {
                    queue.enqueue(current.getLeftChild());
                }
                if (current.hasRightChild()) {
                    queue.enqueue(current.getRightChild());
                }

            }else {

                queue.enqueue(null);

                nivel++;

                if(nivel == n ){

                    BinaryTree<Integer>  dato = queue.dequeue();

                    while (dato != null) {
                        if(dato.isLeaf()){
                            if (dato.getData() < min){
                                min = dato.getData();
                            }
                        }
                        dato = queue.dequeue();
                    }

                    if(min == Integer.MAX_VALUE){
                        min = null;
                    }
                    return min;
                }

            }
        }

        return min;
    }

}
