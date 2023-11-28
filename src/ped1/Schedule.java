/**
 * Clase que representa un calendario de emparejamientos
 */
package ped1;

public class Schedule {

    private int[][] table;

    public Schedule(int n) {
        table = new int[n+1][n];
    }

    public void set(int day, int player, int opponent) {
        table[player][day] = opponent;
    }

    public int get(int player, int day){
        return table[player][day];
    }

    public int rows() {
        return table.length;
    }

    public int colums() {
        return table[0].length;
    }

    /**
     * Imprime por pantalla los emparejamientos de la tabla en sucesivos bloques de hasta 16 días por bloque.
     */
    public void printTable(Players players) {
        int numOfPlayers = players.size();
        int blockSize = 16;
        int totalBlocks = (numOfPlayers / blockSize) + 1;
        int firstDayOfBlock, lastDayOfBlock;
        String namesFormat = "%-10s";
        String daysFormat = "%7s";

        System.out.println("\nCalendario de partidos:\n");
        for (int block = 0; block < totalBlocks; block++) {
            firstDayOfBlock = (block * blockSize) + 1;
            lastDayOfBlock = Math.min((block * blockSize) + blockSize, numOfPlayers - 1);
            for (int player = 0; player < this.rows(); player++) {
                for (int day = firstDayOfBlock; day <= lastDayOfBlock; day++) {
                    if (player == 0) {
                        if (day%blockSize == 1) System.out.format(namesFormat, "");
                        System.out.format(daysFormat, "d" + day);
                    }
                    else {
                        if (day%blockSize == 1) {
                            System.out.format(namesFormat, players.get(player-1));
                        }
                        System.out.format(daysFormat, players.get(this.get(player, day) - 1).toString());
                    }
                    if (day == lastDayOfBlock) System.out.println();
                }
            }
            System.out.println();
        }
    }
}
