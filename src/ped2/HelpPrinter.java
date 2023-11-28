/**
 * HelpPrinter se encarga de imprimir la ayuda
 */
package ped2;

public class HelpPrinter {
    public static void print() {
        String format = "%5s%-20s%s";
        System.out.println("SINTAXIS: sudoku [-t][-h]  [fichero entrada]");
        System.out.format(format, "", "-t", "Traza cada llamada recursiva y sus parámetros.\n");
        System.out.format(format, "", "-h", "Muestra esta ayuda\n");
        System.out.format(format, "", "[fichero entrada]", "Tabla inicial del Sudoku\n");
    }
}
