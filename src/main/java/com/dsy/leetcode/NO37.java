package com.dsy.leetcode;

import com.alibaba.fastjson.JSON;

public class NO37 {
    public static void main(String[] args) {
        NO37 no37 = new NO37();
        char[][] input = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        no37.solveSudoku(input);
        System.out.println(JSON.toJSONString(input));
    }


    private int length;

    private boolean[][] rowUsage = new boolean[9][9];

    private boolean[][] colUsage = new boolean[9][9];

    private boolean[][][] blockUsage = new boolean[3][3][9];

    private boolean finish = false;

    public void solveSudoku(char[][] board) {
        length = board.length;
        for (int i = 0 ; i < length ; i++){
            for (int j = 0 ; j < length ; j++){
                if (board[i][j] != '.'){
                    int numIndex = board[i][j] - '0' - 1;
                    rowUsage[i][numIndex] = true;
                    colUsage[j][numIndex] = true;
                    blockUsage[i / 3][j / 3][numIndex] = true;
                }
            }
        }
        backTrack(board);
    }

    private void backTrack(char[][] board){
        int emptyRow = -1;
        int emptyCol = -1;
        for (int i = 0 ; i < length ; i++){
            if (emptyRow == -1){
                for (int j = 0 ; j < length ; j++){
                    if (board[i][j] == '.'){
                        emptyRow = i;
                        emptyCol = j;
                        break;
                    }
                }
            }else {
                break;
            }
        }

        if (emptyRow == -1){
            finish = true;
            return;
        }

        for (int num = 1 ; num <= 9 ; num++){
            int numIndex = num - 1;
            if (rowUsage[emptyRow][numIndex]){
                continue;
            }
            if (colUsage[emptyCol][numIndex]){
                continue;
            }
            if (blockUsage[emptyRow / 3][emptyCol / 3][numIndex]){
                continue;
            }
            rowUsage[emptyRow][numIndex] = true;
            colUsage[emptyCol][numIndex] = true;
            blockUsage[emptyRow / 3][emptyCol / 3][numIndex] = true;
            board[emptyRow][emptyCol] = (char) (num + '0');

            backTrack(board);

            if (finish){
                break;
            }
            rowUsage[emptyRow][numIndex] = false;
            colUsage[emptyCol][numIndex] = false;
            blockUsage[emptyRow / 3][emptyCol / 3][numIndex] = false;
            board[emptyRow][emptyCol] = '.';
        }
    }
}
