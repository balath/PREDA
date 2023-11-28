/**
 * HelpPrinter se encarga de imprimir la ayuda
 */
package ped1;

public class HelpPrinter {
    public static void print() {
        String format = "%5s%-20s%s";
        System.out.println("SINTAXIS: torneo [-t][-h] n [fichero entrada]");
        System.out.format(format, "", "-t", "Traza la parametrización de cada invocación recursiva\n");
        System.out.format(format, "", "-h", "Muestra esta ayuda\n");
        System.out.format(format, "", "n", "Número de jugadores\n");
        System.out.format(format, "", "[fichero entrada]", "Listado de los nombres de los jugadores del torneo\n");
    }
}
