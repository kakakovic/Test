package main.java.com.dsy;

import java.util.Random;

public class GreedyBandit {
    private int p = 10;

    private double[] choices;

    private int num = 10;

    public static void main(String[] args) {
        GreedyBandit greedyBandit = new GreedyBandit();
        greedyBandit.setChoices(new double[10]);
        new Thread(GreedyBandit::updateChoices).start();
        new Thread(GreedyBandit::updateP).start();
        Random random = new Random();
        int value = Math.abs(random.nextInt()) % 100;
        if (value > greedyBandit.p){
            System.out.println("使用方案: " + greedyBandit.exploit(value));
        }else {
            greedyBandit.explore();
        }
    }

    private int exploit(int random){
        double max = -1;
        int index = 0;
        for (int i = 0 ; i < num ; i++){
            if (choices[i] > max){
                max = choices[i];
                index = i;
            }else if (Math.abs(choices[i] - max) < 0.000001){
                if (random >= 50){
                    index = i;
                }
            }
        }
        return index;
    }

    private void explore(){
        Random random = new Random();
        int choice = Math.abs(random.nextInt()) % num;
        System.out.println("探测方案: " + choice);
    }

    //TODO
    private static void updateP(){

    }

    //TODO
    private static void updateChoices(){

    }

    public double[] getChoices() {
        return choices;
    }

    public void setChoices(double[] choices) {
        this.choices = choices;
    }

}
