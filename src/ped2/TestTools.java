package ped2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestTools {

    public static final int SUDOKU_SIZE = 9;

    public static ArrayList<String> getLinesFromFile(String inputFile) throws Exception {
        ArrayList<String> lines = new ArrayList<>();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            line = bufferedReader.readLine();
            if (line == null) throw new NullPointerException("Empty file");
            do {
                lines.add(line);
                line = bufferedReader.readLine();
            } while (line != null);
            bufferedReader.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

    public static ArrayList<Integer> readSudokuFromFile(String namesFile) throws IOException {
        ArrayList<Integer> sudokuInput = new ArrayList<Integer>();
        String line;
        String[] lineArray;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(namesFile));
            for (int i = 0; i < SUDOKU_SIZE; i++) {
                line = bufferedReader.readLine();
                if (line != null) {
                    lineArray = line.split(" ");
                    for (String character: lineArray) {
                        sudokuInput.add(character.equals("-")? 0 : Integer.parseInt(character));
                    }
                }
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {}
        return sudokuInput;
    }
}
