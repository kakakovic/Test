package leetcode;

import java.util.Stack;

public class NO1047 {
    public static void main(String[] args) {
        new NO1047().removeDuplicates("abbaca");
    }

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        for (int i = 0 ; i < chars.length ; i++){
            if (stack.empty()){
                stack.add(chars[i]);
            }else {
                if (stack.peek() == chars[i]){
                    stack.pop();
                }else {
                    stack.add(chars[i]);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : stack){
            stringBuilder.append(c);
        }
        return stringBuilder.reverse().toString();
    }
}
