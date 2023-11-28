/**
 * ArgumentsReader gestiona los argumentos del usuario
 */
package ped1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ArgumentsReader {

    private boolean trace;
    private ArrayList<Player> players;
    private int numOfPlayers;

    public ArgumentsReader(String[] args)throws IOException{
        Set<String> arguments = Arrays.stream(args).collect(Collectors.toSet());
        //Comprobación del argumento de ayuda
        if (arguments.contains("-h")) {
            HelpPrinter.print();
            System.exit(0);
        }
        //Comprobación del argumento de traza
        trace = arguments.contains("-t");
        //Muestra al usuario los comandos que son desconocidos
        List<String> unknownCommnads = arguments.stream()
                .filter(arg -> arg.startsWith("-") && !arg.equals("-t"))
                .collect(Collectors.toList());
        if (!unknownCommnads.isEmpty()) {
            unknownCommnads.forEach(arg -> System.out.println(arg + " no es un comando válido"));
            System.exit(unknownCommnads.size());
        }
        //Comprobación del argumento del número de jugadores
        readNumberOfPlayers(args, trace? 1 : 0);
        //Comprobación del argumento del archivo de nombres
        Optional<String> namesFile = arguments.stream().filter(arg -> arg.endsWith(".txt")).findFirst();
        if (namesFile.isPresent()) {
            readPlayersSet(namesFile.get());
        } else {
            readPlayersSet();
        }
    }

    private void readNumberOfPlayers(String[] args, int index){
        try {
            numOfPlayers = Integer.valueOf(args[index]);
            if (!Integer.toBinaryString(numOfPlayers).matches("100*"))
                throw new IllegalArgumentException(numOfPlayers + " no es una potencia de 2 mayor que uno");
        } catch (NumberFormatException e) {
            System.out.println(args[index] + " no es un número de jugadores válido");
            System.exit(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No se encontraron argumentos suficientes");
            System.exit(-1);
        }
    }

    private void readPlayersSet(String namesFile) throws IOException {
        players = new ArrayList<>(numOfPlayers);
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(namesFile));
            for (int i = 1; i <= numOfPlayers; i++) {
                line = bufferedReader.readLine();
                if (line != null) {
                    players.add(new Player(i, (line.length() > 6? line.substring(0,6) : line)));
                } else {
                    players.add(new Player(i));
                }
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("El programa continuará sin asignar nombres a los jugadores\n");
            readPlayersSet();
        }
    }

    private void readPlayersSet() {
        players = new ArrayList<>(numOfPlayers);
        for (int i = 1; i <= numOfPlayers; i++) {
            players.add(new Player(i));
        }
    }

    public int getNumOfPlayers(){
        return numOfPlayers;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public boolean withTrace(){
        return trace;
    }
}