package app;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        printGraph("Initial graph:", graph);

        //Checking for vertex 10:
        printResultOfCheck("Vertex 10", graph.hasVertex(10));
        
        graph.addVertex(10);
        printResultOfCheck("Vertex 10", graph.hasVertex(10));

        //Checking for edge 1 -> 10:
        printResultOfCheck("Edge 1 -> 10", graph.hasEdge(1, 10));

        graph.addEdge(1, 10);
        printResultOfCheck("Edge 1 -> 10", graph.hasEdge(1, 10));

        //Removing existing edge 0 -> 2:
        graph.removeEdge(0, 2);
        printResultOfCheck("Edge 0 -> 2", graph.hasEdge(0, 2));

        //Removing existing vertex 4:
        graph.removeVertex(4);
        printResultOfCheck("Vertex 4", graph.hasVertex(4));

        printGraph("Graph with new vertexes and edges:", graph);
    }

    public static void printGraph(String comment, Graph<Integer> graph) {
        System.out.println(comment);
        for (Integer vertex : graph.getGraph().keySet()) {
            for (Integer edge : graph.getGraph().get(vertex)) {
                System.out.println(vertex + " -> " + edge);
            }
        }
    }

    public static void printResultOfCheck(String object, boolean exists) {
        if (exists) {
            System.out.println(object + " already exists");
        } else {
            System.out.println(object + " does not exist");
        }
    }
}
