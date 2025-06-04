package main.java.tp5.ejercicio2;

import main.java.tp5.ejercicio1.Edge;
import main.java.tp5.ejercicio1.Graph;
import main.java.tp5.ejercicio1.Vertex;

import java.util.LinkedList;
import java.util.List;

public class Recorridos <T> {

    // dfs(Graph<T> grafo): List<T> // Retorna una lista con los datos de los vértices, con el recorrido en profundidad del grafo recibido como parámetro.

    public List<T> dfs (Graph<T> grafo){

        List<T> res = new LinkedList<>();

        if (grafo == null || grafo.getSize() == 0) {
            return res;
        }

        boolean[] marca = new boolean[grafo.getSize()]; //creo una marca de visitado segun tamaño del grafo.

        for (int i = 0; i < grafo.getSize(); i++){
            if (!marca[i]){ //si el nodo actual no fue visitado.
                System.out.println("empiezo con : " + grafo.getVertex(i).getData());
                //esto se hace por que depende si el dfs empezo de un nodo y no puedo visitar todos. Busca empezar otra vez. por los nodos que no fueron visitados.
                dfs(i, grafo,marca, res);
            }
        }
        return res;
    }

    private void dfs (int i, Graph<T> grafo, boolean[] marca, List<T> res){

        marca[i] = true;

        Vertex<T> v = grafo.getVertex(i);
        System.out.println(v);
        res.add(v.getData());

        List<Edge<T>> adyacentes = grafo.getEdges(v);

        for (Edge<T> e : adyacentes){
            int j = e.getTarget().getPosition();
            if (!marca[j]){
                dfs(j, grafo, marca, res);
            }
        }

    }

}
