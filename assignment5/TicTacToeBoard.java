package assignment5;

public class TicTacToeBoard {
    private char[][] grid;

    public TicTacToeBoard() {
        grid = new char[][] { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
    }

    public void show() {
        System.out.println("  A B C");
        for (int r = 0; r < 3; r++) {
            System.out.print((r + 1) + " ");
            for (int c = 0; c < 3; c++) {
                System.out.print(grid[r][c] == ' ' ? '□' : grid[r][c]);
                if (c < 2) System.out.print(" ");
            }
            System.out.println();
            if (r < 2) System.out.println("       ");
        }
    }

    public boolean isEmpty(int row, int col) {
        return grid[row][col] == ' ';
    }

    public void placeSymbol(int row, int col, char symbol) {
        grid[row][col] = symbol;
    }

    public static boolean isWinning(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public char[][] getGrid() {
        return grid;
    }
}