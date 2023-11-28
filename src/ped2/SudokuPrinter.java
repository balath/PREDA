package ped2;


public class SudokuPrinter {

    private static SudokuPrinter printer;

    private SudokuPrinter() {}

    public static SudokuPrinter getInstance() {
        if (printer == null) {
            printer = new SudokuPrinter();
        }
        return printer;
    }

    public void print(SudokuTable sudokuInput, SudokuTable solvedSudoku) {
        try {
            int length = sudokuInput.getLength();
            System.out.print("\nSudoku de entrada:       Sudoku solucionado:");
            System.out.println("\n-------------------      -------------------");
            for (int row = 0; row < length; row++) {
                for (int column = 0; column < length; column++) {
                    String cell = String.valueOf(sudokuInput.getCell(row, column));
                    System.out.format("%s ", (cell.equals("0")? "-" : cell));
                    if ((column + 1) % 3 == 0) System.out.print(" ");
                }
                System.out.print("    ");
                for (int column = 0; column < length; column++) {
                    String cell = String.valueOf(solvedSudoku.getCell(row, column));
                    System.out.format("%s ", (cell.equals("0")? "-" : cell));
                    if ((column + 1) % 3 == 0) System.out.print(" ");
                }
                System.out.println();
                if ((row + 1) % 3 == 0) System.out.print("\n");
            }
        } catch (NullPointerException e) {
            System.out.println("El sudoku de entrada no tiene solución");
        }
    }
}
