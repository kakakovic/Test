package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class NO621 {
    public static void main(String[] args) {
        new NO621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B',}, 2);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] times = new int[26];
        for (char task : tasks){
            times[task - 'A']++;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int time : times){
            if (time != 0){
                priorityQueue.add(time);
            }
        }
        int count = 0;
        while (!priorityQueue.isEmpty()){
            int i = 0;
            List<Integer> tmp = new ArrayList<>();
            while (i < n + 1){
                if (!priorityQueue.isEmpty()){
                    Integer task = priorityQueue.poll();
                    if (task > 1){
                        tmp.add(task - 1);
                    }
                }
                count++;
                i++;
                if (priorityQueue.isEmpty() && tmp.size() == 0){
                    break;
                }
            }
            priorityQueue.addAll(tmp);
        }
        return count;
    }
}
