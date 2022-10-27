package CreateBoard;

import java.util.Scanner;
public class TicTacToy {
        //Create a default constructor
        public TicTacToy() {

            System.out.println("Welcome to Tic Tac Toe Game......**");
        }

        static char[] board = new char[10];
        static char player, computer;
        Scanner scan = new Scanner(System.in);

        public void initialize() {
            for (int i = 1; i < 10; i++) {
                board[i] = ' ';
            }
        }

        public static void main(String[] args) {

            //Initialize the object
            TicTacToy d = new TicTacToy();

            //Creating the board
            System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
            System.out.println("*---------*");
            System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
            System.out.println("*---------*");
            System.out.println(board[7] + " | " + board[8] + " | " + board[9]);

        }
    }