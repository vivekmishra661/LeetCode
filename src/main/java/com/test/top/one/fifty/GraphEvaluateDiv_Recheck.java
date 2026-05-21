package com.test.top.one.fifty;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class GraphEvaluateDiv_Recheck {

    static void main() {
        GraphEvaluateDiv_Recheck f = new GraphEvaluateDiv_Recheck();
        //[["a","b"],["a","c"],["d","e"],["d","f"],["a","d"],["aa","bb"],["aa","cc"],["dd","ee"],["dd","ff"],["aa","dd"],["a","aa"]]

        f.calcEquation(List.of(List.of("a", "c"), List.of("b", "e"), List.of("c", "d"), List.of("e", "d")),
                new double[]{2.0, 3.0, 0.5, 5.0},
                List.of(List.of("a", "b"))
        );

        //a = 4e
        //b = 3e
    }

    class RootNodeWight {
        String root;
        double weight;

        public RootNodeWight(double weight, String parent) {
            this.weight = weight;
            this.root = parent;
        }
    }

    class Node {
        double weight;
        String parent;

        public Node(double weight, String parent) {
            this.weight = weight;
            this.parent = parent;
        }

    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Node> map = new HashMap<>();
        //find all nodes
        equations.stream().forEach(e -> {
            map.computeIfAbsent(e.getFirst(), k -> new Node(1.0,  e.getFirst()));
            map.computeIfAbsent(e.getLast(), k -> new Node(1.0,  e.getLast()));
        });
        for (int i = 0; i < values.length; i++) {
            String first = equations.get(i).getFirst();
            String last = equations.get(i).getLast();
            union(map, first, last, values[i]);
        }
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String first = queries.get(i).getFirst();
            String last = queries.get(i).getLast();
            var fRoot = findRoot(map, first);
            var rRoot = findRoot(map, last);
            if(!Objects.equals(fRoot.root, rRoot.root)){
                results[i] = -1.0;
            }else{
                results[i] = fRoot.weight / rRoot.weight;
            }
        }
        return results;
    }




    public void union(HashMap<String, Node> map, String first, String last, double value) {
        var fParent = findRoot(map, first);
        var lParent = findRoot(map, last);
        if (fParent == lParent) {
            return;
        } else {
            var ultimateLRoot = map.get(lParent.root);
            ultimateLRoot.parent = fParent.root;
            ultimateLRoot.weight = value * fParent.weight / lParent.weight;
        }

    }
    // [a-> b-> c-> d ]  [x->y]
    private RootNodeWight findRoot(HashMap<String, Node> map, String s) {
        var currentNode = map.get(s);
        if (Objects.equals(currentNode.parent, s)) {
            return new RootNodeWight(1.0, s);
        }
        var rootEntry = findRoot(map, currentNode.parent);
        currentNode.parent = rootEntry.root;
        currentNode.weight = rootEntry.weight * currentNode.weight;
        return new RootNodeWight(currentNode.weight, currentNode.parent);

    }

}
