/**
 * ArgumentsReader gestiona los argumentos del usuario
 */
package ped2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ArgumentsReader {

    private int sudokuLength;
    private boolean trace;
    private ArrayList<Integer> sudokuInput;


    public ArgumentsReader(String[] args, int sudokuLength)throws IOException{
        this.sudokuLength = sudokuLength;
        Set<String> arguments = Arrays.stream(args).collect(Collectors.toSet());
        //Comprobación del argumento de ayuda
        if (arguments.contains("-h")) {
            HelpPrinter.print();
            System.exit(0);
        }
        //Comprobación del argumento de traza
        trace = arguments.contains("-t");
        //Muestra al usuario los comandos que son desconocidos
        List<String> unknownCommands = arguments.stream()
                .filter(arg -> arg.startsWith("-") && !arg.equals("-t"))
                .collect(Collectors.toList());
        if (!unknownCommands.isEmpty()) {
            unknownCommands.forEach(arg -> System.out.println(arg + " no es un comando válido"));
            System.exit(unknownCommands.size());
        }
        //Comprobación del argumento del archivo de entrada
        Optional<String> inputFile = arguments.stream().filter(arg -> arg.endsWith(".txt")).findFirst();
        sudokuInput = new ArrayList<Integer>();
        if (inputFile.isPresent()) {
            readSudokuFromFile(inputFile.get());
        } else {
            System.out.println("No se encuentra un nombre de archivo válido (*.txt), por favor, " +
                               "revise los argumentos de llamada a la aplicación.");
            System.exit(-1);
        }
    }

    private ArrayList<Integer> readSudokuFromFile(String namesFile) throws IOException {
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(namesFile));
            for (int i = 0; i < sudokuLength; i++) {
                line = bufferedReader.readLine();
                if (line != null) {
                    for (String character: line.split(" ")) {
                        sudokuInput.add(character.equals("-")? 0 : Integer.parseInt(character));
                    }
                }
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("El archivo especificado no existe, " +
                               "se procederá a leer los datos por la entrada estándar.\n");
            readSudokuFromConsole();
        } catch(NumberFormatException e) {
            System.out.println("Formato de entrada de sudoku no válido, el programa terminará.\n");
            System.exit(-1);
        }
        return sudokuInput;
    }

    private void readSudokuFromConsole() throws IOException {
        String line;
        Scanner input = new Scanner(System.in);
        System.out.println("\nIntroduzca línea a línea, con un espacio entre cada celda " +
                "y utilizando guion \"-\" como valor vacío:");
        try {
            for (int i = 0; i < sudokuLength; i++) {
                System.out.format("Línea %d: ", i + 1);
                line = input.nextLine();
                for (String character : line.split(" ")) {
                    sudokuInput.add(character.equals("-") ? 0 : Integer.parseInt(character));
                }
            }
            if (sudokuInput.size() < 81) throw new InputMismatchException();
        } catch (Exception e) {
            System.out.print("El formato de entrada no es válido, pulse enter para " +
                    "volver a intentarlo o \"Q\" para terminar el programa -> ");
            if (input.nextLine().equals("Q")) System.exit(0);
            else readSudokuFromConsole();
        } finally {
            input.close();
        }
    }

    public ArrayList<Integer> getSudokuInput(){
        return sudokuInput;
    }

    public boolean withTrace(){
        return trace;
    }
}