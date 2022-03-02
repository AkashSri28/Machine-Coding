package com.company;

import java.util.Scanner;

public class Board {

    int gameSize;
    char[][] cells;
    Board(int gameSize){
        this.gameSize = gameSize;
        cells = new char[this.gameSize][this.gameSize];
        int i, j;
        for(i=0;i<this.gameSize;i++){
            for(j=0;j<this.gameSize;j++){
                cells[i][j] = '-';
            }
        }
        for(i=0;i<this.gameSize;i++){
            for(j=0;j<this.gameSize;j++){
                System.out.print(cells[i][j]);
            }
            System.out.println();
        }
    }

    void updateBoard(int row, int col, char ch) {
        this.cells[row][col] = ch;
    }

    public void printBoard() {
        int i, j;
        for(i=0;i<this.gameSize;i++){
            for(j=0;j<this.gameSize;j++){
                System.out.print(cells[i][j]);
            }
            System.out.println();
        }
    }

    public Input move(char ch) {
        Scanner in = new Scanner(System.in);
        Input input = new Input();
        int row = in.nextInt(); //3
        int col = in.nextInt(); //3
        input.setRow(row);
        input.setCol(col);
        if(!validMove(row, col)){
            System.out.println("Invalid Move");
            input = move(ch);
        }
        else{
            updateBoard(row, col, ch);
        }

        return input;
    }

    private boolean validMove(int row, int col) {
        return row >= 0 && row < this.gameSize && col >= 0 && col < this.gameSize && this.cells[row][col] == '-';

    }

    public boolean checkResult(Input input, char ch) {
        int i, count, row = input.getRow(), col = input.getCol();
        count=0;
        for(i=0;i<this.gameSize;i++){
            if(this.cells[row][i]==ch){
                count++;
            }
            else{
                break;
            }
        }
        if(count==this.gameSize){
            return true;
        }
        count=0;
        for(i=0;i<this.gameSize;i++){
            if(this.cells[i][col]==ch){
                count++;
            }
            else{
                break;
            }
        }
        if(count==this.gameSize){
            return true;
        }
        if(row == col){
            count=0;
            for(i=0;i<this.gameSize;i++){
                if(this.cells[i][i]==ch){
                    count++;
                }
                else{
                    break;
                }
            }
            if(count==this.gameSize){
                return true;
            }
        }
        if(row + col ==this.gameSize-1){
            count=0;
            for(i=0;i<this.gameSize;i++){
                if(this.cells[i][this.gameSize-1-i]==ch){
                    count++;
                }
                else{
                    break;
                }
            }
            if(count==this.gameSize){
                return true;
            }
        }
        return false;
    }
}
