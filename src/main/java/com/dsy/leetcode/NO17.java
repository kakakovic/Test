package com.dsy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NO17 {
    private Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        NO17 no17 = new NO17();
        List<String> result = no17.letterCombinations("23");

        System.out.println(result);
    }

    private String translate(String input){
        if (input.equals("a") || input.equals("b") || input.equals("c")){
            return "2";
        }
        if (input.equals("d") || input.equals("e") || input.equals("f")){
            return "3";
        }
        if (input.equals("g") || input.equals("i") || input.equals("h")){
            return "4";
        }
        if (input.equals("j") || input.equals("k") || input.equals("l")){
            return "5";
        }
        if (input.equals("m") || input.equals("n") || input.equals("o")){
            return "6";
        }
        if (input.equals("p") || input.equals("q") || input.equals("r") || input.equals("s")){
            return "7";
        }
        if (input.equals("t") || input.equals("u") || input.equals("v")){
            return "8";
        }
        if (input.equals("w") || input.equals("x") || input.equals("y") || input.equals("z")){
            return "9";
        }
        return "0";
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<>();
        }
        int length = digits.length();

        backTrack("", digits, length);
        List<String> finalResult = new ArrayList<>();
        for (String x : result){
            String back = "";
            for (Character c : x.toCharArray()){
                back = back + translate(c.toString());
            }
            if (back.equals(digits)){
                finalResult.add(x);
            }
        }
        return finalResult;
    }

    private List<String> getData(Character x){
        String digits = x.toString();
        List<String> dataList = new ArrayList<>();
        if (digits.equals("2")){
            dataList.add("a");
            dataList.add("b");
            dataList.add("c");
        }
        if (digits.equals("3")){
            dataList.add("d");
            dataList.add("e");
            dataList.add("f");
        }
        if (digits.equals("4")){
            dataList.add("g");
            dataList.add("h");
            dataList.add("i");
        }
        if (digits.equals("5")){
            dataList.add("j");
            dataList.add("k");
            dataList.add("l");
        }
        if (digits.equals("6")){
            dataList.add("m");
            dataList.add("n");
            dataList.add("o");
        }
        if (digits.equals("7")){
            dataList.add("p");
            dataList.add("q");
            dataList.add("r");
            dataList.add("s");
        }
        if (digits.equals("8")){
            dataList.add("t");
            dataList.add("u");
            dataList.add("v");
        }
        if (digits.equals("9")){
            dataList.add("w");
            dataList.add("x");
            dataList.add("y");
            dataList.add("z");
        }
        return dataList;
    }

    private void backTrack(String current, String digits, int length){
        if (current.length() == length){
            result.add(current);
        }
        for (Character c :digits.toCharArray()){
            List<String> data = getData(c);
            for (String s:data){
                current += s;
                backTrack(current, digits.substring(1), length);
                current = current.substring(0, current.length() - 1);
            }

        }
    }
}
