import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isGameOver() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }
    
    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkColumns() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkDiagonals() {
        return ((board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]));
    }
    
    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    
    public void play() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        
        System.out.println("Let's play Tic-Tac-Toe!");
        
        while (!isGameOver()) {
            System.out.println("Current board:");
            printBoard();
            
            System.out.println("Player " + currentPlayer + ", enter your move (row [0-2] and column [0-2]):");
            row = scanner.nextInt();
            col = scanner.nextInt();
            
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            
            if (board[row][col] != '-') {
                System.out.println("Cell already occupied. Try again.");
                continue;
            }
            
            makeMove(row, col);
        }
        
        System.out.println("Final board:");
        printBoard();
        
        if (isBoardFull()) {
            System.out.println("It's a draw!");
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            System.out.println("Player " + currentPlayer + " wins!");
        }
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
