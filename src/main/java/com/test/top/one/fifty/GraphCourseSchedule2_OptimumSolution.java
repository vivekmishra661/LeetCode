package com.test.top.one.fifty;

import java.util.*;

public class GraphCourseSchedule2_OptimumSolution {


    static void main() {
        GraphCourseSchedule2_OptimumSolution graphCourseSchedule2 = new GraphCourseSchedule2_OptimumSolution();
        graphCourseSchedule2.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }

    class Vertices {
        Integer vetice;
        Integer degree = 0;
        Map<Integer, Vertices> neighbour;

        public Vertices(int vetice, int degree) {
            this.vetice = vetice;
            this.degree = degree;
            neighbour = new HashMap<>();
        }
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            int[] n = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                n[i] = i;
            }
            return n;
        }

        Map<Integer, Vertices> uniqueVertices = new LinkedHashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            Integer t = i;
            //indegree [1,0 ]  degree for 1 is 1 and 0 is 0   var[0] dep var[1] prereq
            Integer dependent = prerequisites[t][0];
            Integer prereq = prerequisites[t][1];
            if (uniqueVertices.get(dependent) == null) {
                uniqueVertices.put(dependent, new Vertices(dependent, 0));
            }
            if (uniqueVertices.get(prereq) == null) {
                uniqueVertices.put(prereq, new Vertices(prereq, 0));
            }
            uniqueVertices.get(prereq).neighbour.put(dependent, uniqueVertices.get(dependent));
            uniqueVertices.get(dependent).degree = uniqueVertices.get(dependent).degree + 1;
        }
        Queue<Vertices> queue = new LinkedList<>();
        var itr = uniqueVertices.entrySet().iterator();
        while (itr.hasNext()) {
            var t = itr.next().getValue();
            if (t.degree == 0)
                queue.offer(t);
        }
        int processCount = 0;

        Stack<Integer> s = new Stack<>();
        Set<Integer> m = new HashSet<>();
        while (!queue.isEmpty()) {
            Vertices v = queue.poll();
            if (!m.contains(v.vetice)) {
                s.push(v.vetice);
            }
            m.add(v.vetice);
            var neibours = v.neighbour;
            processCount++;
            for (Vertices value : neibours.values()) {
                value.degree = value.degree - 1;
                if (value.degree == 0) {
                    queue.offer(value);
                }
            }
        }
        if (processCount < uniqueVertices.size()) {
            return new int[]{};
        }
        int[] n = new int[numCourses];
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (!s.contains(i)) {
                n[count] = i;
                count++;
            }
        }
        var t  = s.stream().toList();
        int i = 0;
        while (i<t.size()) {
            n[count] = t.get(i);
            count++;
            i++;
        }
        return n;


    }
}
