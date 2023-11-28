package ped2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

class SudokuSolverTest {

   private SudokuSolver solver = new SudokuSolver(false);;

   @ParameterizedTest
   @MethodSource("sudokusStream")
   void solveSudokus(SudokuTable sudoku) {
      ArrayList<Integer> solvedSudoku = solver.solve(sudoku).getTableList();
      //Asserts not null & not containing unsolved cells
      Assertions.assertNotNull(solvedSudoku);
      Assertions.assertTrue(solvedSudoku.stream().allMatch(cell -> cell != 0));
   }

   static Stream<Arguments> sudokusStream() throws Exception {
      ArrayList<String> filesList = TestTools.getLinesFromFile("C:\\Learn\\Uned\\preda\\sudokus\\lista.txt");
      return filesList.stream().map(fileName -> {
         try {
            return new SudokuTable(
                    TestTools.readSudokuFromFile("C:\\Learn\\Uned\\preda\\sudokus\\" + fileName));
         } catch (IOException e) { return null; }
      }).map(sudoku -> Arguments.arguments(sudoku));
   }

}