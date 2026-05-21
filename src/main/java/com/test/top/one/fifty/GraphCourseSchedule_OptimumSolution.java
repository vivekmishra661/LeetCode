package com.test.top.one.fifty;

import java.util.*;

public class GraphCourseSchedule_OptimumSolution {

    //1->2 2-> 3 3-> 4 1-> 4

    static void main() {
        GraphCourseSchedule_OptimumSolution graphCourseSchedule = new GraphCourseSchedule_OptimumSolution();
        graphCourseSchedule.canFinish(2, new int[][]{{1, 0}, {0, 1}});
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


    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!queue.isEmpty()) {
            Vertices v = queue.poll();
            var neibours = v.neighbour;
            processCount++;
            for (Vertices value : neibours.values()) {
                value.degree = value.degree - 1;
                if (value.degree == 0) {
                    queue.offer(value);
                }
            }
        }
        return processCount == uniqueVertices.size();


    }


}
