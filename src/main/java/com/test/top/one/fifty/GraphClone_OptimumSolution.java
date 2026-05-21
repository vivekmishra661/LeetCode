package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphClone_OptimumSolution {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }



    static void main() {
        GraphClone_OptimumSolution graphClone = new GraphClone_OptimumSolution();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors = List.of(n2,n4);
        n2.neighbors = List.of(n1,n3);
        n3.neighbors = List.of(n2,n4);
        n4.neighbors = List.of(n1,n3);
        var cloneGraph = graphClone.cloneGraph(n1);
        System.out.println(cloneGraph);


    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        Map<Integer, Node> cloneMap = new HashMap<>();
        Node Node = new Node(node.val);
        map.put(node.val, node);
        cloneMap.put(node.val, Node);
        createNodes(node, Node, map, cloneMap);
        createLinkages(map,cloneMap);
        return Node;
    }

    private void createLinkages(Map<Integer, Node> map,Map<Integer, Node> cloneMap ){
        map.entrySet().forEach(entry->{
            var neighbours  = entry.getValue().neighbors;
            var cloneNode = cloneMap.get(entry.getKey());
            if(neighbours!= null){
                neighbours.forEach(n -> cloneNode.neighbors.add(cloneMap.get(n.val)));
            }
        });
    }


    private void createNodes(Node original, Node clone,
                     Map<Integer, Node> map, Map<Integer, Node> cloneMap) {
        original.neighbors.stream().filter(e -> !map.containsKey(e.val))
                .forEach(node -> {
                    Node cloneNode = null;
                    if (!cloneMap.containsKey(node.val)) {
                        cloneNode = new Node();
                        cloneNode.val = node.val;
                        map.put(node.val, node);
                        cloneMap.put(node.val, cloneNode);
                    } else {
                        cloneNode = cloneMap.get(node.val);
                    }
                    createNodes(node, cloneNode, map, cloneMap);
                });
    }
}

