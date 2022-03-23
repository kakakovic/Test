package com.dsy.util;

public class MoneyUtils {
    public static void main(String[] args) {
        MoneyUtils moneyUtils = new MoneyUtils();
        System.out.println(moneyUtils.upValue(70, 0.96, 100));
    }

    double maintainValue(int now, double decreaseRate, int length){
        double result = 0;

        for (int i = 1 ; i <= length ; i++){
            result += now * Math.pow(decreaseRate, i);
        }
        return result;
    }

    double upValue(int now, double decreaseRate, int length){
        double result = 0;

        for (int i = 1 ; i <= length ; i++){
            result += now * Math.pow(decreaseRate, i) * Math.pow(2 - decreaseRate, i);
        }
        return result;
    }
}
