package Hw6_23001938_NguyenVanThang.practice.exericse2;

import java.util.*;

public class CloneGraph {

     static class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public static Node cloneGraph(Node node){
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return cloneChildren(node, map);
    }

    public static Node cloneChildren(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node ans = new Node(node.val);
        map.put(node, ans);
        for (Node child : node.neighbors) {
            ans.neighbors.add(cloneChildren(child, map));
        }
        return ans;
    }

    public static void printGraph(Node node) {
        if (node == null) {
            System.out.println("Graph is empty.");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node.val);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print("Node " + current.val + " neighbors: ");
            for (Node neighbor : current.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.add(neighbor);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // In đồ thị ban đầu
        System.out.println("Original Graph:");
        printGraph(node1);

        // Sao chép đồ thị
        Node clonedGraph = cloneGraph(node1);

        System.out.println();
        // In đồ thị sao chép
        System.out.println("Cloned Graph:");
        printGraph(clonedGraph);

    }
}
