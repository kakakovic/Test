package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NO210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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


        if (sort.size() == numCourses){
            int[] res = new int[numCourses];
            for (int i = 0 ; i < numCourses ; i++){
                res[i] = sort.get(i);
            }
            return res;
        }else {
            return new int[0];
        }
    }
}
