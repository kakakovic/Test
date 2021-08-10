package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO547 {
    public static void main(String[] args) {
        NO547 no547 = new NO547();
        System.out.println(no547.findCircleNum(new int[][]{new int[]{1,0,0,1}, new int[]{0,1,1,0}, new int[]{0,1,1,1}, new int[]{1,0,1,1}}));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> linkList = new ArrayList<>();
        List<Integer> refer = new ArrayList<>();
        //所有城市都和自己相连
        for (int i = 0 ; i < n ; i++){
            List<Integer> data = new ArrayList<>();
            data.add(i);
            linkList.add(data);
            refer.add(i);
        }

        for (int i = 0 ; i < n ; i++){
            for (int j = i + 1 ; j < n ; j++){
                if (isConnected[i][j] == 1){
                    int referIndexLeft = refer.get(i);
                    int referIndexRight = refer.get(j);
                    if (referIndexLeft == referIndexRight){
                        continue;
                    }else if (referIndexLeft < referIndexRight){
                        int referIndex = refer.get(j);
                        List<Integer> referData = linkList.get(referIndex);
                        int toIndex = refer.get(i);
                        linkList.get(i).addAll(referData);
                        linkList.set(referIndex, new ArrayList<>());
                        refer.set(j, toIndex);
                    }else {
                        int referIndex = refer.get(i);
                        List<Integer> referData = linkList.get(referIndex);
                        int toIndex = refer.get(j);
                        linkList.get(toIndex).addAll(referData);
                        linkList.set(referIndex, new ArrayList<>());
                        refer.set(i, toIndex);
                    }

                }
            }
        }

        int count = 0;
        for (List<Integer> province :linkList){
            if (province.size() > 0){
                count++;
            }
        }

        return count;
    }
}
