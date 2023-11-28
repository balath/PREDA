package ped2;

import java.io.IOException;

public class sudoku {


    public static final int SUDOKU_SIZE = 9;

    public static void main(String[] args) throws IOException {
        ArgumentsReader arguments = new ArgumentsReader(args, SUDOKU_SIZE);
        SudokuTable sudokuInput = new SudokuTable(arguments.getSudokuInput());
        SudokuSolver solver = new SudokuSolver(arguments.withTrace());
        SudokuTable sudokuOutput = solver.solve(sudokuInput);
        SudokuPrinter.getInstance().print(sudokuInput, sudokuOutput);
    }
}
