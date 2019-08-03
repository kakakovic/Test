package leetcode;

public class NO1137 {
    private int[] dynamic = new int[38];
    public int tribonacci(int n) {
        if (n == 0) {
            dynamic[n] = 0;
            return 0;
        }
        if (n == 1 || n == 2) {
            dynamic[n] = 1;
            return 1;
        }
        if (dynamic[n] != 0){
            return dynamic[n];
        }
        dynamic[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        return dynamic[n];
    }
}
