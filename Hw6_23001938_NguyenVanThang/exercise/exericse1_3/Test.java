package Hw6_23001938_NguyenVanThang.exercise.exericse1_3;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 5);
        graph.addEdge(1, 6);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 7);

        System.out.println("The number of edges of the graph: " + graph.numEdge());
        System.out.println("The number of vertices of the graph: " + graph.numVertices());
        System.out.println("The degree of the graph: " + graph.degreeGraph());
        int u = 0, v = 2;
        System.out.println("Is edge between two vertices " + u + " and " + v + " ?: " + graph.isEdge(0, 2));
        int w = 0;
        List<Integer> list = graph.adjVertices(w);
        System.out.print("List of adjacency vertices of " + w + ": " + list);

        System.out.println();

        System.out.println("Run BFS start source = 0");
        graph.BFS(0);

        System.out.println();

        System.out.println("Run DFS start source = 0");
        graph.DFS(0);
    }
}
