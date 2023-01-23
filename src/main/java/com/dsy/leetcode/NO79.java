package com.dsy.leetcode;

public class NO79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] usage = new boolean[board.length][board[0].length];
        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                if (board[i][j] == word.charAt(0)){
                    usage[i][j] = true;
                    if (dfs(board, usage, word.substring(1), i, j)){
                        return true;
                    }
                    usage[i][j] = false;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先遍历
     * @param word 当前剩余的搜索词
     * @param startRow 最后一个匹配元素的横坐标
     * @param startCol 最后一个匹配原色的纵坐标
     */
    private boolean dfs(char[][]board, boolean[][]usage, String word, int startRow, int startCol){
        if (word.length() == 0){
            return true;
        }
        char current = word.charAt(0);
        if (word.length() == 1){
            //up
            if (startRow > 0){
                if (current == board[startRow - 1][startCol] && !usage[startRow - 1][startCol]){
                    return true;
                }
            }

            //down
            if (startRow < board.length - 1){
                if (current == board[startRow + 1][startCol] && !usage[startRow + 1][startCol]){
                    return true;
                }
            }

            //left
            if (startCol > 0){
                if (current == board[startRow][startCol - 1] && !usage[startRow][startCol - 1]){
                    return true;
                }
            }

            //right
            if (startCol < board[0].length - 1){
                if (current == board[startRow][startCol + 1] && !usage[startRow][startCol + 1]){
                    return true;
                }
            }

            //找不到合理解，就返回失败
            return false;
        }

        //up
        if (startRow > 0){
            if (current == board[startRow - 1][startCol] && !usage[startRow - 1][startCol]){
                usage[startRow - 1][startCol] = true;
                if (dfs(board, usage, word.substring(1), startRow - 1, startCol)){
                    return true;
                }else {
                    usage[startRow - 1][startCol] = false;
                }
            }
        }

        //down
        if (startRow < board.length - 1){
            if (current == board[startRow + 1][startCol] && !usage[startRow + 1][startCol]){
                usage[startRow + 1][startCol] = true;
                if (dfs(board, usage, word.substring(1), startRow + 1, startCol)){
                    return true;
                }else {
                    usage[startRow + 1][startCol] = false;
                }
            }
        }

        //left
        if (startCol > 0){
            if (current == board[startRow][startCol - 1] && !usage[startRow][startCol - 1]){
                usage[startRow][startCol - 1] = true;
                if (dfs(board, usage, word.substring(1), startRow, startCol - 1)){
                    return true;
                }else {
                    usage[startRow][startCol - 1] = false;
                }
            }
        }

        //right
        if (startCol < board[0].length - 1){
            if (current == board[startRow][startCol + 1] && !usage[startRow][startCol + 1]){
                usage[startRow][startCol + 1] = true;
                if (dfs(board, usage, word.substring(1), startRow, startCol + 1)){
                    return true;
                }else {
                    usage[startRow][startCol + 1] = false;
                }
            }
        }

        return false;
    }
}
