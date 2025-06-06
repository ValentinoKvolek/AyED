package main.java.tp5.ejercicio3;

import main.java.tp5.ejercicio1.Edge;
import main.java.tp5.ejercicio1.Graph;
import main.java.tp5.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

    Graph<String> mapaCiudades;


    // retorna la lista de ciudades que se deber atraversar para ir de ciudad1 a ciudad2 en caso de que se pueda llegar, si no se retorna la lista vacia.

    public List<String> devolverCamino (String ciudad1, String ciudad2){

        List<String> camino = new ArrayList<String>();

        if (ciudad1 == null || ciudad2 == null){
            return camino;
        }

        Vertex<String> origen = null;
        Vertex<String> destino = null;

        for (Vertex<String> v : mapaCiudades.getVertices()) {
            if (v.getData().equals(ciudad1)) {
                origen = v;
            }
            if (v.getData().equals(ciudad2)) {
                destino = v;
            }
        }

        if (origen == null || destino == null){
            return camino; //si no existen, no hay camino posible
        }

        boolean[] marca = new boolean[mapaCiudades.getSize()];


        boolean encontrado = dfs(origen.getPosition(), destino.getPosition(), mapaCiudades, marca , camino);

        if (encontrado) {
            return camino;
        } else {
            return new ArrayList<>();
        }
    }

    private boolean dfs( int i ,  int f, Graph<String> grafo, boolean[] visitados, List<String> camino) {

        visitados[i] = true;

        Vertex<String> v = grafo.getVertex(i);

        camino.add(v.getData());

        if ( v.getData().equals(grafo.getVertex(f).getData())) {

            return true;

        }

        List<Edge<String>> adyacentes = grafo.getEdges(v);

        for (Edge<String> e : adyacentes) {
            int j = e.getTarget().getPosition();

            if (!visitados[j]) {

                if (dfs(j,f, grafo, visitados, camino)) {
                    return true; // si encontre el camino retorno true.
                }

            }
        }

        camino.remove(camino.size()-1); // si no backtracking

        return false;
    }

    public List<String> devolverCaminoExeptuando (String ciudad1, String ciudad2, List<String> ciudades) {

        List<String> camino = new ArrayList<String>();

        if (ciudad1 == null || ciudad2 == null){
            return camino;
        }
        Vertex<String> origen = null;
        Vertex<String> destino = null;

        for (Vertex<String> v : mapaCiudades.getVertices()) {
            if (v.getData().equals(ciudad1)) {
                origen = v;
            }
            if (v.getData().equals(ciudad2)) {
                destino = v;
            }
        }

        if (origen == null || destino == null){
            return camino; //si no existen, no hay camino posible
        }

        boolean[] marca = new boolean[mapaCiudades.getSize()];

        boolean encontrado = dfsExeptuando(origen.getPosition(), destino.getPosition(), mapaCiudades, marca , camino, ciudades);

        if (encontrado) {
            return camino;
        } else {
            return new ArrayList<>();
        }

    }
    private boolean dfsExeptuando(int i ,  int f, Graph<String> grafo, boolean[] visitados, List<String> camino, List<String> ciudades) {

        visitados[i] = true;
        Vertex<String> v = grafo.getVertex(i);

        if(ciudades.contains(v.getData())) {
            return false;
        }
        camino.add(v.getData());
        if(v.getData().equals(grafo.getVertex(f).getData())) {
            return true;
        }
        List<Edge<String>> adyacentes = grafo.getEdges(v);

        for (Edge<String> e : adyacentes) {
            int j = e.getTarget().getPosition();
            if (!visitados[j]) {
                if (dfsExeptuando(j, f, mapaCiudades, visitados , camino, ciudades)) {
                    return true;
                }
            }
        }

        camino.remove(camino.size()-1);
        return false;
    }

}
