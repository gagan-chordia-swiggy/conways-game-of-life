package org.example;

import java.util.Random;
import java.util.Scanner;

/**
 * Conway's Game of Life
 * Reference: <a href="https://pi.math.cornell.edu/~lipa/mec/lesson6.html#:~:text=For%20each%20generation%20of%20the,it%20has%203%20live%20neighbors">Rules of the game by Cornell University</a>
 */
public class GameService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter number of columns: ");
        int columns = scanner.nextInt();

        double seedPercent = new Random().nextDouble(0, 1);

        Board board = new Board(rows, columns, seedPercent);

        System.out.println("Simulation begins");
        initializeGame(board);
        System.out.println("Simulation ended");
    }

    private static void initializeGame(Board board) {
        Scanner scanner = new Scanner(System.in);
        int iteration = 1;

        while (!board.allCellsDead()) {
            System.out.println("Iteration " + iteration);
            board.display();
            board.evolve();

            System.out.println("Press `C` to continue or Press `E` to exit");
            String userInput = scanner.next();

            if (userInput.equalsIgnoreCase("e")) {
                break;
            }

            ++iteration;
        }
    }
}
