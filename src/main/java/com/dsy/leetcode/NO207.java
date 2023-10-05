package com.dsy.leetcode;

import java.util.*;

public class NO207 {
    public static void main(String[] args) {
        NO207 no207 = new NO207();
        no207.canFinish(2, new int[][]{new int[]{1,0}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //拓扑排序
        List<Integer> sort = new ArrayList<>();

        List<List<Integer>> edgeList = new ArrayList<>();
        int[] inCount = new int[numCourses];
        for (int i = 0 ; i < numCourses ; i++){
            edgeList.add(new ArrayList<>());
            inCount[i] = 0;
        }

        for (int[] prerequisite : prerequisites) {
            int in = prerequisite[1];
            int out = prerequisite[0];
            inCount[out]++;
            edgeList.get(in).add(out);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < inCount.length ; i++){
            if (inCount[i] == 0){
                queue.add(i);
                sort.add(i);
            }
        }

        while (!queue.isEmpty()){
            int num = queue.poll();
            List<Integer> nextNode = edgeList.get(num);
            for (int node : nextNode){
                inCount[node]--;
                if (inCount[node] == 0){
                    queue.add(node);
                    sort.add(node);
                }
            }
        }


        return sort.size() == numCourses;
    }
}
