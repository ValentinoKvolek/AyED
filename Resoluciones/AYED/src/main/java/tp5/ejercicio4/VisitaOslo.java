package main.java.tp5.ejercicio4;

import main.java.tp5.ejercicio1.Edge;
import main.java.tp5.ejercicio1.Graph;
import main.java.tp5.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class VisitaOslo {

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {

        List<String> camino = new ArrayList<String>();
        boolean[] visitados = new boolean[lugares.getSize()];
        boolean encontre = false;

        if (!lugares.isEmpty()) {

            Vertex<String> origen = lugares.search("ayuntamiento");
            Vertex<String> llegada = lugares.search(destino);

            if (origen != null && llegada != null) {
                encontre = paseoEnBici(origen.getPosition(), llegada.getPosition(),camino, visitados ,lugares, maxTiempo, lugaresRestringidos, 0);
            }
        }

        if (encontre) {
            return camino;
        }
        return new ArrayList<>();
    }

    private boolean paseoEnBici(int i, int f,List<String> camino ,boolean[] visitados, Graph<String> lugares, int maxTiempo, List<String> lugaresRestringidos, int sumaTiempo) {

        Vertex<String> v = lugares.getVertex(i);

        if (lugaresRestringidos.contains(v.getData())) {
            return false;
        }

        visitados[i] = true;
        camino.add(v.getData());

        if(v.getData().equals(lugares.getVertex(f).getData())){
            return true; //encontre el camino
        }

        List<Edge<String>> edges = lugares.getEdges(v);

        for (Edge<String> e : edges){

            int j = e.getTarget().getPosition();

            int total = sumaTiempo + e.getWeight();
            if(!visitados[j] && total <= maxTiempo) {
                if (paseoEnBici(j, f, camino, visitados, lugares, maxTiempo, lugaresRestringidos, total)) {
                    return true;
                }
            }
        }

        camino.remove(camino.size()-1);
        visitados[i]=false;

        return false;

    }

}

