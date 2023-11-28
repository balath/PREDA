

package ped2;

import java.util.ArrayList;

public class SudokuSolver {

    private boolean trace;
    private int sudokuLength;
    private SudokuTable solvedSudoku;


    public SudokuSolver(boolean trace){
        this.trace = trace;
    }

    public SudokuTable solve(SudokuTable sudokuTable) {
        sudokuLength = sudokuTable.getLength();
        Boolean solved = false;
        trackTable(sudokuTable, 0, 0, 1, solved);
        return solvedSudoku;
    }

    private void trackTable(SudokuTable sudoku, int row, int column, int value, Boolean solved) {
        //Cuando se llega a la última columna, la llamada salta a la siguiente fila.
        if (column == sudokuLength) {
            trackTable(sudoku, row + 1, 0, value, solved);
            return;
        }
        //Cuando se llega a la última fila, el sudoku está resuelto.
        if (row == sudokuLength) {
            processTable(sudoku.getTableList());
            solved = true;
            return;
        }
        //Si la celda ya contiene un número válido, se salta al siguiente.
        if (sudoku.getCell(row, column) != 0) {
            trackTable(sudoku, row, column + 1, value, solved);
            return;
        }
        //Llamada para imprimir la traza si se ha solicitado al programa.
        if (trace) System.out.println(
                new StringBuilder()
                        .append("trackTable(matriz: sudoku, fila: ")
                        .append(row + 1)
                        .append(", columna: ")
                        .append(column + 1)
                        .append(", valor:" + value + ")")
        );
        //Si el valor para la celda es válido, se abre una nueva rama de exploración.
        if (isValid(sudoku, row, column, value)) {
            SudokuTable newBranch = new SudokuTable(sudoku.getTableList(), row, column, value);
            trackTable(newBranch, row, column + 1, 1, solved);
        }
        //Mientras que no se haya resuelto el sudoku, se continúan explorando los valores posibles.
        if (!solved && value < sudokuLength) trackTable(sudoku, row, column, value + 1, solved);
    }

    private void processTable(ArrayList<Integer> sudoku) {
        solvedSudoku = new SudokuTable(sudoku);
        trace = false;
    }

    private boolean isValid(SudokuTable sudoku, int row, int column, int value) {
        return isValidSubmatrix(sudoku, row, column, value) &&
                isValidRow(sudoku, row, column, value) &&
                isValidColumn(sudoku, row, column, value);
    }

    private boolean isValidColumn(SudokuTable sudoku, int row, int column, int value) {
        for (int i = 0; i < sudokuLength; i++) {
            if (sudoku.getCell(i, column) == value && row != i) return false;
        }
        return true;
    }

    private boolean isValidRow(SudokuTable sudoku, int row, int column, int value) {
        for (int i = 0; i < sudokuLength; i++) {
            if (sudoku.getCell(row, i) == value && column != i) return false;
        }
        return true;
    }

    private boolean isValidSubmatrix(SudokuTable sudoku, int row, int column, int value) {
        int lengthSqrt = (int) Math.sqrt(sudokuLength);
        int initialRow = (row / lengthSqrt) * lengthSqrt;
        int initialColumn = (column / lengthSqrt) * lengthSqrt;
        int checkRow, checkColumn;
        boolean isOtherCell;
        for (int i = 0; i < lengthSqrt; i++) {
            for (int j = 0; j < lengthSqrt; j++) {
                checkRow = initialRow + i;
                checkColumn = initialColumn + j;
                isOtherCell = checkColumn != column || checkRow != row;
                if (sudoku.getCell(checkRow, checkColumn) == value && isOtherCell) return false;
            }
        }
        return true;
    }

}
