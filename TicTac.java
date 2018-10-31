//made by Ngoc Nguyen

import java.util.*;

public class TicTac{
   //declare a constant
   public static final int SIZE = 3; //size of each row and each column

   public static void main(String[] args) {
      //declare a board
      char[][] m = new char[SIZE][SIZE];
      //initialize the board to an empty board (call initializeBoard method here)
      initializeBoard(m);
      //display the empty board (call the displayBoard method here)
      displayBoard(m);


      //prompt for the first player
      System.out.println("Who wants to go first (X or O)?");
      Scanner input = new Scanner(System.in);
      String firstPlayer = " ";
      boolean invalidInput = true;
      while (invalidInput) {
        if (input.hasNextLine())  {
          firstPlayer = input.nextLine();
          if (firstPlayer.equals("X") || firstPlayer.equals("O")) {
            invalidInput = false;
          }
          else {
            System.out.println("Input must be either X or O");
          }
        }
        else {
          System.out.println("Input must be either X or O");
          input.next();
        }
      }

      //if first player is X then second player is O, vice versa
      char player = firstPlayer.charAt(0);
      char player2 = ' ';
      if (player == 'X') {
        player2 = 'O';
      }
      else if (player == 'O') {
        player2 = 'X';
      }

      /** take turns to make moves, before each move prompt for target position,
       after each move, check if there is a winner
       and display the board */
      //You have to come up with a logic to call the other defined methods here.
      int movelimit = 0;
      while (findWinner(m) == false && hasEmptyCell(m) == false) {
        getMove(m, player);
        findWinner(m);
        if (findWinner(m) == false) {
        }
        displayBoard(m);
        movelimit ++;
        if (movelimit == 9) {
          hasEmptyCell(m);
          findWinner(m);
          if (findWinner(m) == false && hasEmptyCell(m) == true) {
            System.out.println("It's a draw!");
          }
        }
        else if (findWinner(m) == false) {
          getMove(m, player2);
          findWinner(m);
          displayBoard(m);
          movelimit ++;
        }
      }

   }


   //Method: initializeBoard
   //Purpose: initialize each cell in the array with a blank space character
    public static void initializeBoard(char[][] board){
      //complete the method here
      for (int i = 0; i < board.length; i ++)
        for (int j = 0; j < board.length; j ++) {
          board[i][j] = ' ';
        }
    }


   //Method: displayBoard
   //Purpose: display the current board on screen
   public static void drawLine() {
      for (int i = 0; i <= 4 * SIZE; i++) {
         System.out.print("-");
      }
      System.out.println();
   }

   public static void displayBoard(char[][] board) {
      drawLine();
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            System.out.print("| " + board[i][j] + " ");
         }
         System.out.println("|");
         drawLine();
      }
      System.out.println();
   }

   //Method: getMove
   //Purpose: to prompt the current player for a target position, and place the mark in the position if the position is available.
   public static void getMove(char[][] board, char player) {
    Scanner input = new Scanner(System.in);
    int rowNumber = 0;
    int columnNumber = 0;
    int occupiedspace = 0;


    while (occupiedspace == 0) {

      boolean invalidRowInput = true;
      boolean invalidColumnInput = true;

      while (invalidRowInput) {
        System.out.println("Enter a row (0,1,2) for player " + player + ":");
        if (input.hasNextInt())  {
          rowNumber = input.nextInt();
          if (rowNumber >= 0 && rowNumber <= 2) {
            invalidRowInput = false;
          }
          else {
            System.out.println("Input must be between integer 0 to 2");
          }
        }
        else {
          System.out.println("Input must be between integer 0 to 2");
          input.next();
        }
      }


      while (invalidColumnInput) {
        System.out.println("Enter a column (0,1,2) for player " + player + ":");
        if (input.hasNextInt())  {
          columnNumber = input.nextInt();
          if (columnNumber >= 0 && columnNumber <= 2) {
            invalidColumnInput = false;
          }
          else {
            System.out.println("Input must be between integer 0 to 2");
          }
        }
        else {
          System.out.println("Input must be between integer 0 to 2");
          input.next();
        }

      }


      if (board[rowNumber][columnNumber] == (' ')) {
        board[rowNumber][columnNumber] = player;
        occupiedspace = 1; //turn ends when occupiedspace turned 1
      }
      else if (board[rowNumber][columnNumber] == ('X')) {
        System.out.println("That square is already taken");
      }
      else if (board[rowNumber][columnNumber] == ('O')) {
        System.out.println("That square is already taken");
      }
     }

   }

   //Method: findWinner
   //Purpose: after each move, check the board and see if any player has achieve a win.
   public static boolean findWinner(char[][] board) {
   //check all the win conditions

     if (board[0][0] == ('X') && board[0][1] == ('X') && board[0][2] == ('X')) {
       System.out.println("X player won!");
       return true;
     }
     else if (board[1][0] == ('X') && board[1][1] == ('X') && board[1][2] == ('X')) {
       System.out.println("X player won!");
       return true;
     }
     else if (board[2][0] == ('X') && board[2][1] == ('X') && board[2][2] == ('X')) {
       System.out.println("X player won!");
       return true;
     }
     else if (board[0][0] == ('X') && board[1][0] == ('X') && board[2][0] == ('X')) {
       System.out.println("X player won!");
       return true;
     }
     else if (board[0][1] == ('X') && board[1][1] == ('X') && board[2][1] ==  ('X')) {
       System.out.println("X player won!");
       return true;
     }
     else if (board[0][2] == ('X') && board[1][2] == ('X') && board[2][2] == ('X')) {
       System.out.println("X player won!");
       return true;
     }
     else if (board[0][0] == ('X') && board[1][1] == ('X') && board[2][2] == ('X')) {
       System.out.println("X player won!");
       return true;
     }
     else if (board[0][2] == ('X') && board[1][1] == ('X') && board[2][0] == ('X')) {
       System.out.println("X player won!");
       return true;
     }



     else if (board[0][0] == ('O') && board[0][1] == ('O') && board[0][2] == ('O')) {
       System.out.println("O player won!");
       return true;
     }
     else if (board[1][0] == ('O') && board[1][1] == ('O') && board[1][2] == ('O')) {
       System.out.println("O player won!");
       return true;
     }
     else if (board[2][0] == ('O') && board[2][1] == ('O') && board[2][2] == ('O')) {
       System.out.println("O player won!");
       return true;
     }
     else if (board[0][0] == ('O') && board[1][0] == ('O') && board[2][0] == ('O')) {
       System.out.println("O player won!");
       return true;
     }
     else if (board[0][1] == ('O') && board[1][1] == ('O') && board[2][1] ==  ('O')) {
       System.out.println("O player won!");
       return true;
     }
     else if (board[0][2] == ('O') && board[1][2] == ('O') && board[2][2] == ('O')) {
       System.out.println("O player won!");
       return true;
     }
     else if (board[0][0] == ('O') && board[1][1] == ('O') && board[2][2] == ('O')) {
       System.out.println("O player won!");
       return true;
     }
     else if (board[0][2] == ('O') && board[1][1] == ('O') && board[2][0] == ('O')) {
       System.out.println("O player won!");
       return true;
     }

     else {
       return false;
     }
   }


   //Method: hasEmptyCell
   //Purpose: check if there are still any empty spots on the board
    public static boolean hasEmptyCell(char[][] board) {

      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == ' ') {
            //check if there any blank spaces left

            return false;
          }
        }
      }
      return true;

    }


}
