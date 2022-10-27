package TicTacToyProblem;

import java.util.Random;
import java.util.Scanner;

public class FreeSpace {
    public FreeSpace() {
        System.out.println("Welcome to Tic Tac Toe Game .....**");
    }

    static char[] board = new char[10];
    static char player, remote;
    static int playerLocation, remoteLocation;
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        //Initialize the object
        FreeSpace d = new FreeSpace();
        //Initialize board
        d.initialize();
        //Checking for player choice
        chooseOption();
        //Showing board
        showBoard();
        //Player move
        playerMove();
        //Computer move
        computerMove();
        //Check available space
        checkFreeSpace();

    }

    //Initialization of game
    public void initialize()
    {
        for (int i = 1; i < 10; i++)
        {
            board[i] = ' ';
        }
    }

    //Allow player to choose X or O
    public static void chooseOption()
    {
        System.out.println("Please Select Your Choice Letter : \nProvide 'X' or 'O'");
        char choice = scan.next().charAt(0);
        if (choice == 'X' || choice == 'x')
        {
            player = 'X';
            remote = 'O';
        }
        else if (choice == 'O' || choice == 'o')
        {
            player = 'O';
            remote = 'X';
        }
        System.out.println("Player choosing option : "+player);
    }

    //To see board
    public static void showBoard()
    {
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    //To make the player move
    public static void playerMove()
    {
        System.out.println("Enter the position between (1-9) you want to make your move first :");
        playerLocation = scan.nextInt();
        if (playerLocation > 0 && playerLocation < 10)
        {
            if (board[playerLocation] == ' ')
            {
                board[playerLocation] = player;
                showBoard();
            }
            else if (board[playerLocation] != ' ')
            {
                System.err.println("Position is already chosen. Enter a valid position");
                showBoard();
                playerMove();
            }
        }
        else
        {
            System.err.println("Invalid choice. Provide a valid position between (1-9)");
            playerMove();
        }
    }

    //To make the computer move
    public static void computerMove()
    {
        remoteLocation = random.nextInt(8)+1;//Random gives 0 to 8 so +1 give you 1 to 9 position.
        if (remoteLocation > 0 && remoteLocation < 10)
        {
            if (board[remoteLocation] == ' ')
            {
                board[remoteLocation] = remote;
                showBoard();
            }
            else if (board[remoteLocation] != ' ')
            {
                computerMove();
                showBoard();
            }
        }
    }

    //To check free space
    public static void checkFreeSpace()
    {
        boolean isSpaceAvailable = false;
        int numOfFreeSpaces = 0;
        for(int index=1; index<board.length; index++)
        {
            if((board[index] == ' '))
            {
                isSpaceAvailable = true;
                numOfFreeSpaces++;
            }
        }
        if(isSpaceAvailable == false)
        {
            System.err.println("Board is full! You can't make another move");
        }
        else
        {
            System.out.println("Free space is available! you have "+numOfFreeSpaces+ " moves left");
        }
    }
}
