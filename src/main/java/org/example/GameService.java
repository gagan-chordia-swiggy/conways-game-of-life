package org.example;

import java.util.Scanner;

public class GameService {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simulation begins");

        System.out.println("Enter number of rows");
        int rows = scanner.nextInt();

        System.out.println("Enter number of columns");
        int columns = scanner.nextInt();

        Board board = new Board(rows, columns);

        int iteration = 1;
        while (!board.checkAllCellsDead() && !board.inSameState()) {
            System.out.println("Iteration: " + iteration);

            board.displayBoard();
            board.evolve();

            System.out.println("Press `0` to exit");
            int userInput = scanner.nextInt();

            if (userInput == 0) {
                System.out.println("Breaking out");
                break;
            }

            ++iteration;
        }

        System.out.println("Simulation Ends");
    }
}
