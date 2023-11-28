/**
 * Tracer que gestiona las trazas de llamadas recursivas que realiza el algoritmo recursivo de divide y vencerás
 */
package ped1;
import java.util.ArrayList;


public class Tracer {

    private ArrayList<String> traces;

    public Tracer(){
        traces = new ArrayList<>();
    }

    /**
     * Imprime por pantalla el registro de trazas
     */
    public void print() {
        System.out.println("\nTraza de las llamadas recursivas:\n");
        traces.forEach(System.out::println);
    }

    /**
     * Registra una traza de la llamada recursiva
     */
    public void recordTrace(int from, int to) {
        traces.add(new StringBuilder()
                .append("Scheduler.scheduleLeague(")
                .append(from)
                .append(", ")
                .append(to)
                .append(")")
                .toString()
        );
    }
}
