package com.dsy.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class NO51 {
    public static void main(String[] args) {
        NO51 no51 = new NO51();
        no51.solveNQueens(4);
    }

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        backtrack(new ArrayList<>(), n);
        System.out.println(JSON.toJSONString(result));
        return result;
    }

    private void backtrack(List<String> current, int n){
        if (current.size() == n){
            result.add(new ArrayList<>(current));
            return;
        }
        int i = current.size();
        for (int j = 0 ; j < n ; j++){
            List<Integer> usedCol = getUsedColumn(current);
            List<Integer> usedL2R = getUsedLeft2Right(current);
            List<Integer> usedR2L = getUsedRight2Left(current);
            if (usedCol.contains(j) || usedL2R.contains(j - i) || usedR2L.contains(i + j)){
                continue;
            }else {
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = 0 ; k < n ; k++){
                    if (j == k){
                        stringBuilder.append("Q");
                    }else {
                        stringBuilder.append(".");
                    }
                }
                String tmp = stringBuilder.toString();
                current.add(tmp);

                backtrack(current, n);

                current.remove(current.size() - 1);
            }
        }
    }

    private List<Integer> getUsedColumn(List<String> current){
        List<Integer> result = new ArrayList<>();
        for (String s : current){
            int i = 0;
            while (true){
                char c = s.charAt(i);
                if ("Q".equals(String.valueOf(c))){
                    result.add(i);
                    break;
                }else {
                    i++;
                }
            }
        }
        return result;
    }

    private List<Integer> getUsedLeft2Right(List<String> current){
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < current.size() ; i++){
            int j = 0;
            String s = current.get(i);
            while (true){
                char c = s.charAt(j);
                if ("Q".equals(String.valueOf(c))){
                    result.add(j - i);
                    break;
                }else {
                    j++;
                }
            }
        }
        return result;
    }

    private List<Integer> getUsedRight2Left(List<String> current){
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < current.size() ; i++){
            int j = 0;
            String s = current.get(i);
            while (true){
                char c = s.charAt(j);
                if ("Q".equals(String.valueOf(c))){
                    result.add(i + j);
                    break;
                }else {
                    j++;
                }
            }
        }
        return result;
    }
}
