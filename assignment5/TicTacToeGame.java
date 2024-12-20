package assignment5;

import java.util.Scanner;

public class TicTacToeGame {
    private TicTacToeBoard board;
    private TicTacToePlayer playerX;
    private TicTacToePlayer playerO;
    private TicTacToePlayer currentPlayer;
    private int moves;
    private boolean gameWon;
    private Scanner scanner;

    public TicTacToeGame() {
        board = new TicTacToeBoard();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        boolean playAgain = true;
        while (playAgain) {
            setupPlayers();
            newMatch();
            while (moves < 9 && !gameWon) {
                board.show();
                promptMove();
            }
            playAgain = askToPlayAgain();
        }
        scanner.close();
        System.out.println("Thanks for playing this modified TicTacToe!");
    }

    private void setupPlayers() {
        System.out.print("Name for Player X: ");
        String nameX = scanner.nextLine().trim();
        nameX = nameX.isEmpty() ? "Player X" : nameX;

        System.out.print("Name for Player O: ");
        String nameO = scanner.nextLine().trim();
        nameO = nameO.isEmpty() ? "Player O" : nameO;

        playerX = new TicTacToePlayer(nameX, 'X');
        playerO = new TicTacToePlayer(nameO, 'O');
        currentPlayer = playerX;
    }

    private void newMatch() {
        board.reset();
        moves = 0;
        gameWon = false;
        System.out.println("\n--- A fresh TicTacToe match has started! ---\n");
    }

    private void promptMove() {
        System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + "), choose spot (e.g. 'A 1'):");
        String input = scanner.nextLine().toUpperCase();
        if (input.matches("[A-C] [1-3]")) {
            int col = input.charAt(0) - 'A';
            int row = Integer.parseInt(input.split(" ")[1]) - 1;
            if (board.isEmpty(row, col)) {
                board.placeSymbol(row, col, currentPlayer.getSymbol());
                moves++;
                if (TicTacToeBoard.isWinning(board.getGrid(), currentPlayer.getSymbol())) {
                    board.show();
                    System.out.println(currentPlayer.getName() + " WINS!");
                    gameWon = true;
                } else if (moves == 9) {
                    board.show();
                    System.out.println("It's a draw!");
                } else {
                    togglePlayer();
                }
            } else {
                System.out.println("Spot taken, try another.");
            }
        } else {
            System.out.println("Invalid format. Use 'A 1' format.");
        }
    }

    private void togglePlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    private boolean askToPlayAgain() {
        System.out.print("Play again? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }
}