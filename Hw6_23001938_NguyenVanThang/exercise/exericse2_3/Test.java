package Hw6_23001938_NguyenVanThang.exercise.exericse2_3;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        WeightGraph weightGraph = new WeightGraph(6);
//        weightGraph.addEdge(0, 1, 15);
//        weightGraph.addEdge(0, 2, 16);
//        weightGraph.addEdge(1, 3, 17);
//        weightGraph.addEdge(1, 4, 18);
//        weightGraph.addEdge(2, 5, 19);
//        weightGraph.addEdge(2, 6, 20);
//        weightGraph.addEdge(4, 7, 21);
//        weightGraph.addEdge(5, 8, 22);
        weightGraph.addEdge(0, 1, 10);
        weightGraph.addEdge(0, 2, 5);
        weightGraph.addEdge(0, 3, 18);
        weightGraph.addEdge(1, 3, 12);
        weightGraph.addEdge(2, 3, 5);
        weightGraph.addEdge(3, 5, 8);
        weightGraph.addEdge(2, 5, 5);
        weightGraph.addEdge(2, 4, 14);
        weightGraph.addEdge(4, 5, 7);
        System.out.println("The number of vertices of the weight graph: " + weightGraph.numVertices());
        System.out.println("The number of edges of the weight graph: " + weightGraph.numEdge());
        System.out.println("The degree of the weight graph: " + weightGraph.degreeGraph());
        int u = 5, v = 4;
        System.out.println("Is edge between two vertices " + u + " and " + v + " ?: " + weightGraph.isEdge(5, 4));
        int w = 0;
        List<Integer> list = weightGraph.adjVertices(w);
        System.out.print("List of adjacency vertices of " + w + ": " + list);

        System.out.println();

        System.out.println("Run BFS start source = 0");
        weightGraph.BFS(0);

        System.out.println();

        System.out.println("Run DFS start source = 0");
        weightGraph.DFS(0);
    }
}
