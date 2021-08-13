package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO547 {
    public static void main(String[] args) {
        NO547 no547 = new NO547();

        System.out.println(no547.findCircleNum(new int[][]{
                new int[]{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                new int[]{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                new int[]{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},

                new int[]{0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                new int[]{0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                new int[]{1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                new int[]{0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},

                new int[]{0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                new int[]{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                new int[]{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                new int[]{0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                new int[]{0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
        }));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        //并查集元素集合
        List<List<Integer>> linkList = new ArrayList<>();

        //当前元素属于哪个并查集
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
                    //将靠后并查集中的元素尽可能挪到前面的并查集中
                    if (referIndexLeft == referIndexRight){
                        continue;
                    }else{
                        //要挪动的并查集
                        int referIndex;
                        //要挪动到的并查集
                        int toIndex;
                        if (referIndexLeft < referIndexRight){
                            referIndex = refer.get(j);
                            toIndex = refer.get(i);
                        }else {
                            referIndex = refer.get(i);
                            toIndex = refer.get(j);

                        }

                        List<Integer> referData = linkList.get(referIndex);
                        linkList.get(toIndex).addAll(referData);
                        linkList.set(referIndex, new ArrayList<>());
                        for (Integer num : referData){
                            refer.set(num, toIndex);
                        }
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
