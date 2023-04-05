import java.util.Scanner;

public class ticTacToe 
{
    public static void printBoard(char[][] board)
    {
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                System.err.print(board[row][col] + "|");
            }
            System.out.println();
        }
    }
    public static boolean haveWon(char[][] board, char player)
    {
        // Check the rows
        for(int row = 0; row < board.length; row++)
        {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player)
            {
                return true;
            }
        }

        // Check for col
        for(int col = 0; col < board[0].length; col++)
        {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player)
            {
                return true;
            }
        }

        // Check for diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
        {
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player)
        {
            return true;
        }

        return false;
    }
    public static void main(String[] args) 
    {
        char[][] board = new char[3][3];
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
            {
                board[row][col] = ' ';
            }
        }    

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while(!gameOver)
        {
            printBoard(board);
            System.err.println("Player "+ player +" enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if(board[row][col] == ' ')
            {
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if(gameOver)
                {
                    System.err.println("Player "+ player +" has won!");
                    printBoard(board);
                }
                else
                {
                    player = (player == 'X') ? 'O' : 'X';
                }
            }
            else
            {
                System.err.println("Invalid move. Try again");
            }
        }
        sc.close();
    }    
}