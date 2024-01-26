package org.example;

public class GameService {
    private final Board board;

    public GameService(Board board) {
        if (board == null) {
            throw new NullPointerException("Game board hasn't been initialized");
        }
        this.board = board;
    }

    public void displayBoard() {
        board.display();
    }
}
