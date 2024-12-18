import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            char[][] board = { {'□', '□', '□'}, {'□', '□', '□'}, {'□', '□', '□'} };
            char currentPlayer = 'X';
            int moves = 0;
            boolean gameWon = false;

            while (moves < 9 && !gameWon) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + ", enter your move (e.g., A 1): ");
                String input = scanner.nextLine().toUpperCase();

                if (input.matches("[A-C] [1-3]")) {
                    String[] parts = input.split(" ");
                    int col = parts[0].charAt(0) - 'A';
                    int row = Integer.parseInt(parts[1]) - 1;

                    if (board[row][col] == '□') {
                        board[row][col] = currentPlayer;
                        moves++;
                        if (checkWin(board, currentPlayer)) {
                            printBoard(board);
                            System.out.println("Player " + currentPlayer + " wins!");
                            gameWon = true;
                        } else if (moves == 9) {
                            printBoard(board);
                            System.out.println("It's a draw!");
                        } else {
                            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        }
                    } else {
                        System.out.println("Position already taken. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please use format 'A 1', 'B 2', etc.");
                }
            }

            System.out.println("Game over. Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static void printBoard(char[][] board) {
        System.out.println("  A B C");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;
        return false;
    }
}
