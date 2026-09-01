package controllers;

import models.GameBoard;

public class BoardController {
    public void printBoard(GameBoard gameBoard){

        for (int i = 0; i < 3; i++) {
            // Print the row values
            for (int j = 0; j < 3; j++) {
                // If cell is the default null char, print a space instead
                char val = gameBoard.getCell(i, j);
                val = (val == '\u0000') ? ' ' : val;

                System.out.print(" " + val + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();

            // Print horizontal dividers between rows
            if (i < 2) {
                System.out.println("-----------");
            }
        }
    }
}
