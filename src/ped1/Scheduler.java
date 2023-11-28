/**
 * Scheduler implementa el algoritmo que calcula los emparejamientos del torneo según los argumentos pasados
 */
package ped1;
public class Scheduler {

    public Schedule schedule;
    private Players players;
    private Tracer traces;

    public Scheduler(ArgumentsReader arguments){
        schedule = new Schedule(arguments.getNumOfPlayers());
        players = new Players(arguments.getPlayers());
        traces = new Tracer();
        scheduleTournament(1, arguments.getNumOfPlayers());
    }

    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Hace las llamadas necesarias para imprimir por pantalla las trazas, si se ha solicitado,
     * y la tabla de emparejamientos
     */
    public void printSchedule(boolean trace) {
        if (trace) traces.print();
        schedule.printTable(players);
    }

    /**
     * Implementa el algoritmo divide y vencerás para realizar los emparejamientos del torneo
     */
    private void scheduleTournament(int from, int to) {
        traces.recordTrace(from, to);
        if ((to - from) == 1) {
            schedule.set(1, from, to);
            schedule.set(1, to, from);
            return;
        }
        int middle = (from + to - 1) / 2;
        scheduleTournament(from, middle);
        scheduleTournament(middle + 1, to);
        pairTeams(from, to);
    }

    /**
     * Implementa la función que combina los resultados de la división del problema
     */
    private void pairTeams(int from, int to) {
        int middleTeam = ((from + to) % 2) + ((from + to) / 2);
        int teams = to - from + 1;
        int teamsAfterMiddle = (teams / 2) + (teams % 2);
        int aTeam, bTeam, matchDay;
        for (int day = 0; day < teamsAfterMiddle; day++) {
            matchDay = day + (teams / 2);
            for (int currentTeam = 0; currentTeam < teams / 2; currentTeam++) {
                aTeam = from + currentTeam;
                bTeam = middleTeam + ((day + currentTeam) % teamsAfterMiddle);
                schedule.set(matchDay, aTeam, bTeam);
                schedule.set(matchDay, bTeam, aTeam);
            }
        }
    }
}