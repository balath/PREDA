package ped2;

import java.util.ArrayList;

public class SudokuTable {

    private int sudokuLength;
    private ArrayList<Integer> tableList;

    public SudokuTable(ArrayList<Integer> listInput){
        sudokuLength = (int) Math.sqrt(listInput.size());
        tableList = new ArrayList<>(listInput);
    }

    public SudokuTable(ArrayList<Integer> listInput, int row, int column, int value){
        sudokuLength = (int) Math.sqrt(listInput.size());
        tableList = new ArrayList<>(listInput);
        int index = (row * sudokuLength) + column;
        tableList.set(index, value);
    }

    public int getCell(int row, int column){
        int index = (row * sudokuLength) + column;
        return tableList.get(index);
    }

    public ArrayList<Integer> getTableList() {
        return tableList;
    }

    public int getLength() {
        return sudokuLength;
    }
}
