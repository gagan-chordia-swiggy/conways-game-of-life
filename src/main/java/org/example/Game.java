package org.example;

public class Game {
    private final Board board;

    public Game(Board board) {
        if (board == null) {
            throw new NullPointerException("Game board hasn't been initialized");
        }
        this.board = board;
    }

    public void displayBoard() {
        board.display();
    }
}
