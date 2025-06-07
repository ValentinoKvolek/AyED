package main.java.tp5.ejercicio5;

import main.java.tp1.ejercicio8.Queue;
import main.java.tp5.ejercicio1.Edge;
import main.java.tp5.ejercicio1.Graph;
import main.java.tp5.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.List;


public class BancoItau {


    public List<Persona> listaJubilados(Graph<Persona> grafo, Persona empleado, int gradoSeparacion){

        List<Persona> jubilados = new ArrayList<>();

        boolean[] visitados = new boolean[ grafo.getSize()];

        if(!grafo.isEmpty()) {
            Vertex<Persona> origen = grafo.search(empleado);

            if (origen != null) {
                this.listaJubilados(origen.getPosition(), grafo, visitados, jubilados, gradoSeparacion, 0);
            }

            return jubilados;
        }

        return new ArrayList<>();

    }

    private void listaJubilados (int i, Graph<Persona> grafo ,boolean[] visitados, List<Persona> jubilados, int gradoSeparacion , int distancia ){

        Queue<Vertex<Persona>> queue = new Queue<Vertex<Persona>>();
        queue.enqueue(grafo.getVertex(i));
        queue.enqueue(null); //marca de nivel
        visitados[i]= true;

        while(!queue.isEmpty()){

            Vertex<Persona> v = queue.dequeue();

            if(v != null) { //como no es la marca de nivel

                if (v.getData().jubilado && distancia < gradoSeparacion && jubilados.size() < 40) {
                    jubilados.add(v.getData());
                    if (jubilados.size() == 40) return;
                }

                List<Edge<Persona>> edges = grafo.getEdges(v);

                for (Edge<Persona> e : edges){
                    int j = e.getTarget().getPosition();
                    if(! visitados[j]){
                        visitados[j] = true;
                        queue.enqueue(e.getTarget());
                    }
                }
            }else {
                if(!queue.isEmpty()){

                    distancia ++;

                    if(distancia >= gradoSeparacion){
                        return;
                    }

                    queue.enqueue(null);
                }
                else {
                    return;
                }
            }
        }
    }
}
