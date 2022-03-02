package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Player p1 =new Player();
        Player p2 =new Player();


        Scanner in = new Scanner(System.in);
        p1.setName(in.next());
        p2.setName(in.next());
        System.out.println(p2.getName());

        Player[] players = new Player[2];
        players[0] = p1;
        players[1] = p2;

        //game size can be changed in future based on requirements
        int gameSize = 3;

        //Initialise Board
        Board board = new Board(gameSize);


        startGame(board, gameSize, players);

    }

    private static void startGame(Board board, int gameSize, Player[] players) {
        int counter = 0;
        Input input;
        while(counter < gameSize*gameSize){
            if(counter % 2 == 0){
                System.out.println("Player 1's turn, enter your move");
                input = board.move('X');
                board.printBoard();
                if(board.checkResult(input, 'X')){
                    System.out.println(players[0].getName() + " wins");
                    return;
                }
                counter++;
            }
            else{
                System.out.println("Player 2's turn, enter your move");
                input = board.move('O');
                board.printBoard();
                if(board.checkResult(input, 'O')){
                    System.out.println(players[1].getName() + " wins");
                    return;
                }
                counter++;
            }
        }
        System.out.println("Draw");
    }
}
