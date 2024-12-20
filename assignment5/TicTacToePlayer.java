package assignment5;

public class TicTacToePlayer {
    private char symbol;
    private String name;

    public TicTacToePlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}