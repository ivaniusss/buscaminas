//import java.util.ArrayList;
//import java.util.List;
import java.util.logging.Logger;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Minesweeper {

    static final Logger logger = Logger.getLogger(Minesweeper.class.getName());

    public  static int[][] generateBoard(int n){
        int board[][] = new int[n][n];

        for (int row = 0; row < n; row++){
            for (int column = 0; column < n; column++){
                board[row][column] = 0;
                int randomNum = ThreadLocalRandom.current().nextInt(1, 6);
                if (randomNum == 5){
                    board[row][column] = 1;
                }
            }
        }
        return board;
    }

    public static int countMines(int[][] board,int n){
        int count = 0;
        for (int row = 0; row < n; row++){
            for (int column = 0; column < n; column++){
                if (board[row][column] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public static int[][] generateBoardStatic(int n){
        int board[][] = new int[n][n];

        for (int row = 0; row < n; row++){
            for (int column = 0; column < n; column++){
                board[row][column] = 0;
                if (row == column){
                    board[row][column] = 1;
                }
            }
        }
        return board;
    }

    public  static void printBoard(int[][] board, int n){
        for (int row = 0; row < n; row++){
            for (int column = 0; column < n; column++){
                if (board[row][column] != -1){
                    logger.info("O");
                }
                else {
                    logger.info("X");
                }
                logger.info("\t");
            }
            logger.info("\n");
        }
    }

    public  static Boolean checkMove(int[][] board, int x, int y){
        if (board[x][y] == 1){
            logger.info("Game Over");
            return true;
        }
        else {
            return false;
        }
    }

    public  static int inputCoord(int n){
        while (true) {
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            if (number >= n || number < 0) {
                logger.info("Coordenada invalida, vuelva a ingresar coordenada: ");
            }
            else{
                return number;
            }
        }
    }

    public static int inputCoordString(int n){
        while (true) {
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            if (number >= n || number < 0) {
                logger.info("Coordenada invalida, vuelva a ingresar coordenada: ");
            }
            else{
                return number;
            }
        }
    }

    public static int inputBoardSize(){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        return number;
    }

    public static boolean play(int count, int[][] board,int n){
        Boolean gameOver = false;
        for (int i=0 ; i<n*n-count; i++){
            printBoard(board, n);
            logger.info("Ingrese coordenada x: ");
            int x = inputCoord(n);
            logger.info("\nIngrese coordenada y: ");
            int y = inputCoord(n);
            logger.info("\n");
            gameOver = checkMove(board, x, y);
            if (!gameOver){
                board[x][y] = -1;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        logger.info("Tamaño del tablero: ");
        int n = inputBoardSize();
        logger.info("\n");
        int board[][] = generateBoard(n);
        int count = countMines(board,n);
        
        boolean win = play(count, board, n);
        if (win){
            logger.info("WINNER!!");
        }else{
            logger.info("LOSSER");
        }
    }
}
