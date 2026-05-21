package com.test.algos;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    static void main() {
        Test f = new Test();
        //[["a","b"],["a","c"],["d","e"],["d","f"],["a","d"],["aa","bb"],["aa","cc"],["dd","ee"],["dd","ff"],["aa","dd"],["a","aa"]]

        f.calcEquation(List.of(List.of("a", "c"), List.of("b", "e"), List.of("c", "d"),List.of("e", "d")),
                new double[]{2.0, 3.0, 0.5,5.0},
                List.of(List.of("a", "b"))
        );

        //a = 4e
        //b = 3e
    }
    class Node {
        String parent;
        double weight;

        Node(String parent, double weight) {
            this.parent = parent;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            union(u, v, values[i], map);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if (!map.containsKey(u) || !map.containsKey(v)) {
                results[i] = -1.0;
            } else {
                Node rootU = find(u, map);
                Node rootV = find(v, map);

                if (!rootU.parent.equals(rootV.parent)) {
                    results[i] = -1.0;
                } else {
                    // Since u = root * rootU.weight and v = root * rootV.weight
                    // u / v = rootU.weight / rootV.weight
                    results[i] = rootU.weight / rootV.weight;
                }
            }
        }
        return results;
    }

    private Node find(String i, Map<String, Node> map) {
        if (!map.containsKey(i)) {
            map.put(i, new Node(i, 1.0));
            return map.get(i);
        }

        Node node = map.get(i);
        if (!node.parent.equals(i)) {
            // Path Compression: recursively find root and update weight
            Node root = find(node.parent, map);
            node.parent = root.parent;
            node.weight *= root.weight;
        }
        return node;
    }

    private void union(String u, String v, double value, Map<String, Node> map) {
        Node rootU = find(u, map);
        Node rootV = find(v, map);

        if (!rootU.parent.equals(rootV.parent)) {
            // Connect the root of U to the root of V
            // u = rootU_parent * rootU_weight
            // v = rootV_parent * rootV_weight
            // target: u / v = value  => (rootU_parent * rootU_weight) / (rootV_parent * rootV_weight) = value
            // rootU_parent = rootV_parent * (value * rootV_weight / rootU_weight)
            rootU.parent = rootV.parent;
            rootU.weight = value * rootV.weight / rootU.weight;
        }
    }

}
