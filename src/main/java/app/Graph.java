package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T extends Comparable<T>> {
    Map<T, List<T>> graph = new HashMap<>();

    public void addVertex(T vertex) {
        graph.put(vertex, new ArrayList<>());
    }

    public void addEdge(T source, T destination) {
        graph.putIfAbsent(source, new ArrayList<>());
        graph.get(source).add(destination);
    }

    public void removeVertex(T vertex) {
        graph.remove(vertex);

        //find vertex as destination:
        graph.entrySet().stream()
                .filter(entry -> entry.getValue().contains(vertex))
                .forEach(entry -> entry.getValue().remove(vertex));
    }

    public void removeEdge(T source, T destination) {
        graph.get(source).remove(destination);
    }

    public boolean hasVertex(T vertex) {
        return graph.containsKey(vertex);
    }

    public boolean hasEdge(T source, T destination) {
        return graph.get(source).contains(destination);
    }

    public Map<T, List<T>> getGraph() {
        return graph;
    }
}
